package com.cimri.config;

import com.cimri.service.ProductService;
import com.cimri.service.ProductServiceImpl;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * @author ozlem
 */
@Configuration
public class ProductConfiguration {

   @Bean
   public DriverManagerDataSource dataSource() {
      DriverManagerDataSource dataSource = new DriverManagerDataSource();
      DatabaseConnection dbConnection = databaseConnection();
      dataSource.setDriverClassName(dbConnection.getDriverClassName());
      dataSource.setUrl(dbConnection.getJdbcUrl());
      dataSource.setUsername(dbConnection.getUsername());
      dataSource.setPassword(dbConnection.getPassword());
      return dataSource;
   }

   @Bean
   public ProductService productService() {
      ProductService productService = new ProductServiceImpl();
      productService.setDataSource(dataSource());
      return productService;
   }

   @Bean
   public DatabaseConnection databaseConnection() {
      return new DatabaseConnection();
   }

   @Bean
   public PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {

      PropertyPlaceholderConfigurer propertyPlaceholderConfigurer = new PropertyPlaceholderConfigurer();
      propertyPlaceholderConfigurer.setLocation(new ClassPathResource("jdbc.properties"));

      return propertyPlaceholderConfigurer;
   }
}
