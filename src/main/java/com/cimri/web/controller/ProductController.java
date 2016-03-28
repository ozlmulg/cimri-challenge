package com.cimri.web.controller;

import com.cimri.entity.Product;
import com.cimri.service.ProductService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author ozlem
 */
@Controller
public class ProductController extends WebMvcConfigurerAdapter {

   @Autowired
   ProductService productService;

   private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

   @RequestMapping(value = "/", method = RequestMethod.GET)
   public String addProductView() {
      return "main";
   }

   @RequestMapping("/list-products")
   public String listProductsView(@RequestParam(value = "query", required = true) String query, Model model) {
      List<Product> products = productService.getProductsLikeTitle(query);
      model.addAttribute("products", products);
      model.addAttribute("query", query);
      return "product-list";
   }

   @RequestMapping("/product") //USAGE= http://localhost:8080/product?id=1000
   public String getProductView(@RequestParam(value = "id", required = true) String id, Model model) {
      try {
         Product product = productService.getProduct(Integer.parseInt(id));
         model.addAttribute("id", product.getId());
         model.addAttribute("title", product.getTitle());
         model.addAttribute("brand", product.getBrand());
         model.addAttribute("category", product.getCategory());
         model.addAttribute("url", product.getUrl());
         return "product";
      } catch (Exception ex) {
         logger.error("This is Error message", ex);
         model.addAttribute("message", "No such product found with id=" + id);
         return "error";
      }
   }
}
