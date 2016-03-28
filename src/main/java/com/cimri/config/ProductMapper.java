package com.cimri.config;

import com.cimri.entity.Product;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 * @author ozlem
 */
public class ProductMapper implements RowMapper<Product> {

   public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
      Product product = new Product();
      product.setId(rs.getInt("id"));
      product.setTitle(rs.getString("title"));
      product.setBrand(rs.getString("brand"));
      product.setCategory(rs.getString("category"));
      product.setUrl(rs.getString("url"));
      return product;
   }
}
