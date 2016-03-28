package com.cimri;

import com.cimri.config.ProductConfiguration;
import com.cimri.service.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author ozlem
 */
@ComponentScan
@EnableAutoConfiguration
public class Application {

   public static void main(String[] args) {

      ApplicationContext context = new AnnotationConfigApplicationContext(ProductConfiguration.class);
      ProductService productService = context.getBean(ProductService.class);
      productService.readXml("src/main/resources/sites/site1.xml");
      productService.readXml("src/main/resources/sites/site2.xml");
      productService.readXml("src/main/resources/sites/site3.xml");
      productService.readXml("src/main/resources/sites/site4.xml");
      SpringApplication.run(Application.class);
   }
}
