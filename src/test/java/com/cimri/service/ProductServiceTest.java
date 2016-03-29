package com.cimri.service;

import com.cimri.entity.Product;
import com.cimri.entity.ProductPrice;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

/**
 * @author ozlem.ulag
 */
@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

   @Mock
   ProductServiceImpl productService;

   /**
    * Test main page search by title
    */
   @Test
   public void testGetProductsLikeTitle() {
      String query = "tablet";
      List<Product> productsContainsQuery = getProducts().stream()
                                                         .filter(product -> product.getTitle().toLowerCase().contains("tablet".toLowerCase()))
                                                         .collect(Collectors.toList());
      when(productService.getProductsLikeTitle(anyString())).thenReturn(productsContainsQuery);
      List<Product> productsLikeTitle = productService.getProductsLikeTitle(query);

      assertThat(productsLikeTitle.size()).isEqualTo(productsContainsQuery.size());
   }

   /**
    * Test product page
    */
   @Test
   public void testGetProduct() {
      Integer id = 1;
      when(productService.getProduct(anyInt())).thenReturn(getProduct());
      Product productReturned = productService.getProduct(id);

      assertThat(productReturned.getTitle()).isEqualTo(getProduct().getTitle());
      assertThat(productReturned.getBrand()).isEqualTo(getProduct().getBrand());
      assertThat(productReturned.getCategory()).isEqualTo(getProduct().getCategory());
      assertThat(productReturned.getUrl()).isEqualTo(getProduct().getUrl());
   }

   /**
    * Test product price info
    */
   @Test
   public void testGetProductPrices() {
      Integer id = 1;
      when(productService.getProductPrices(anyInt())).thenReturn(getProductPrices());
      List<ProductPrice> productPricesReturned = productService.getProductPrices(id);

      assertThat(productPricesReturned.size()).isEqualTo(getProductPrices().size());
      assertThat(productPricesReturned.get(0).getProductId()).isEqualTo(1);
   }


   private Product getProduct() {
      Product product = new Product();
      product.setId(1);
      product.setTitle("Test Product");
      product.setBrand("Test Brand");
      product.setCategory("Test Category");
      product.setUrl("www.testsite.com?id=1");
      return product;
   }

   private List<ProductPrice> getProductPrices() {
      List<ProductPrice> productPrices = new ArrayList<ProductPrice>();
      ProductPrice productPrice = new ProductPrice();
      productPrice.setProductId(getProduct().getId());
      productPrice.setPrice(10);
      productPrice.setDate(new Date());

      ProductPrice productPrice2 = new ProductPrice();
      productPrice2.setProductId(getProduct().getId());
      productPrice2.setPrice(20);
      productPrice2.setDate(new Date());

      ProductPrice productPrice3 = new ProductPrice();
      productPrice3.setProductId(getProduct().getId());
      productPrice3.setPrice(30);
      productPrice3.setDate(new Date());

      productPrices.add(productPrice);
      productPrices.add(productPrice2);
      productPrices.add(productPrice3);
      return productPrices;
   }

   private List<Product> getProducts() {
      List<Product> products = new ArrayList<Product>();
      Product product = new Product();
      product.setId(1);
      product.setTitle("Tablet x y z");
      product.setBrand("Test Brand");
      product.setCategory("Test Category");
      product.setUrl("www.testsite.com?id=1");

      Product product2 = new Product();
      product2.setId(2);
      product2.setTitle("Kalem");
      product2.setBrand("Test Brand");
      product2.setCategory("Test Category2");
      product2.setUrl("www.testsite.com?id=2");

      Product product3 = new Product();
      product3.setId(3);
      product3.setTitle("Tablet z q x");
      product3.setBrand("Test Brand2");
      product3.setCategory("Test Category");
      product3.setUrl("www.testsite2.com?id=3");

      products.add(product);
      products.add(product2);
      products.add(product3);
      return products;
   }
}
