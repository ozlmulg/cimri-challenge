package com.cimri;
/**
 * @author ozlem
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
public class Application {

   static Logger log = LoggerFactory.getLogger(Application.class.getName());

   public static void main(String[] args) {
      SpringApplication.run(Application.class);
   }
}
