package com.cimri.config;

import com.cimri.entity.ProductPrice;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 * @author ozlem.ulag
 */
public class ProductPriceMapper implements RowMapper<ProductPrice> {

   @Override
   public ProductPrice mapRow(ResultSet rs, int rowNum) throws SQLException {
      ProductPrice productPrice = new ProductPrice();
      productPrice.setProductId(rs.getInt("product_id"));
      productPrice.setPrice(rs.getInt("price"));
      productPrice.setDate(rs.getDate("date"));
      return productPrice;
   }
}
