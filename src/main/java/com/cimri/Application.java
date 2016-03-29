package com.cimri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author ozlem
 * firstly run XMLFileReader class.
 */
@ComponentScan
@EnableAutoConfiguration
public class Application {

   public static void main(String[] args) {
      SpringApplication.run(Application.class);
   }
}
