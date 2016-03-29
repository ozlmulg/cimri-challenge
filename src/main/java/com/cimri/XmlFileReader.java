package com.cimri;

import com.cimri.config.ProductConfiguration;
import com.cimri.service.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author ozlem.ulag
 * please firstly run this class to move xml data to cimri database.
 */
public class XmlFileReader {

   public static void main(String[] args) {
      ApplicationContext context = new AnnotationConfigApplicationContext(ProductConfiguration.class);
      ProductService productService = context.getBean(ProductService.class);
      productService.readXml("src/main/resources/sites/site1.xml");
      productService.readXml("src/main/resources/sites/site2.xml");
      productService.readXml("src/main/resources/sites/site3.xml");
      productService.readXml("src/main/resources/sites/site4.xml");
   }
}
