package com.cimri.service;

import com.cimri.config.ProductMapper;
import com.cimri.config.ProductPriceMapper;
import com.cimri.entity.Product;
import com.cimri.entity.ProductPrice;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.sql.DataSource;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author ozlem
 */
public class ProductServiceImpl implements ProductService {

   private DataSource dataSource;

   private JdbcTemplate jdbcTemplate;

   private final static Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

   public void setDataSource(DataSource dataSource) {
      this.dataSource = dataSource;
      this.jdbcTemplate = new JdbcTemplate(dataSource);
   }

   public DataSource getDataSource() {
      return dataSource;
   }

   @Override
   public void insertProductBatch(final List<Product> products) {

      String SQL = "replace into Product (id, title, brand, category, url) values (?, ?, ?, ?, ?)";

      jdbcTemplate.batchUpdate(SQL, new BatchPreparedStatementSetter() {

         @Override
         public void setValues(PreparedStatement ps, int i) throws SQLException {
            Product product = products.get(i);
            ps.setInt(1, product.getId());
            ps.setString(2, product.getTitle());
            ps.setString(3, product.getBrand());
            ps.setString(4, product.getCategory());
            ps.setString(5, product.getUrl());
         }

         @Override
         public int getBatchSize() {
            return products.size();
         }
      });
   }

   @Override
   public void insertProductPriceBatch(final List<ProductPrice> productPrices) {
      String SQL = "replace INTO product_price (product_id, price, date) VALUES (?, ?, ?)";

      jdbcTemplate.batchUpdate(SQL, new BatchPreparedStatementSetter() {

         @Override
         public void setValues(PreparedStatement ps, int i) throws SQLException {
            ProductPrice productPrice = productPrices.get(i);
            ps.setInt(1, productPrice.getProductId());
            ps.setInt(2, productPrice.getPrice());
            ps.setDate(3, new java.sql.Date(productPrice.getDate().getTime()));
         }

         @Override
         public int getBatchSize() {
            return productPrices.size();
         }
      });
   }

   @Override
   public Product getProduct(Integer id) {
      String SQL = "select * from Product where id = ?";
      return jdbcTemplate.queryForObject(SQL, new Object[]{id}, new ProductMapper());
   }

   @Override
   public List<ProductPrice> getProductPrices(Integer productId) {
      String SQL = "select * from product_price where product_id = " + productId + " order by date asc";
      return jdbcTemplate.query(SQL, new ProductPriceMapper());
   }

   @Override
   public List<Product> getProductsLikeTitle(String title) {
      String query = "'%".concat(title).concat("%'");
      String SQL = "select * from Product WHERE title LIKE " + query;
      return jdbcTemplate.query(SQL, new ProductMapper());
   }

   @Override
   public void readXml(String fileUrl) {
      try {
         logger.info("Started to read file..");
         File file = new File(fileUrl);
         DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
         Document document = documentBuilder.parse(file);

         NodeList nodeList = document.getElementsByTagName("row");
         List<Product> products = new ArrayList<Product>();
         List<ProductPrice> productPrices = new ArrayList<ProductPrice>();
         for (int temp = 0; temp < nodeList.getLength(); temp++) {
            Node node = nodeList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
               Element element = (Element) node;

               Integer id = Integer.parseInt(element.getElementsByTagName("id").item(0).getTextContent());
               String title = element.getElementsByTagName("title").item(0).getTextContent();
               String brand = element.getElementsByTagName("brand").item(0).getTextContent();
               String category = element.getElementsByTagName("category").item(0).getTextContent();
               String url = element.getElementsByTagName("url").item(0).getTextContent();

               String productPriceValues = element.getElementsByTagName("prices").item(0).getTextContent();
               String productDateValues = element.getElementsByTagName("dates").item(0).getTextContent();

               String[] priceList = productPriceValues.split(",");
               String[] dateList = productDateValues.split(",");

               for (int i = 0; i < priceList.length; i++) {
                  try {
                     Double priceDouble = Double.parseDouble(priceList[i]);
                     Integer price = (int) (priceDouble * 100);
                     Date date = new Date(Long.parseLong(dateList[i]));
                     ProductPrice productPrice = new ProductPrice();
                     productPrice.setProductId(id);
                     productPrice.setPrice(price);
                     productPrice.setDate(date);
                     productPrices.add(productPrice);
                  } catch (Exception ignored) {
                  }
               }
               Product product = new Product();
               product.setId(id);
               product.setTitle(title);
               product.setBrand(brand);
               product.setCategory(category);
               product.setUrl(url);
               products.add(product);
            }
         }
         insertProductBatch(products);
         insertProductPriceBatch(productPrices);
         logger.info("Finished to read file..");
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}
