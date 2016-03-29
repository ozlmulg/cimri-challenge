package com.cimri.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author ozlem.ulag
 */
@Entity
public class ProductPrice {

   @Column
   private Integer productId;

   @Column
   private Integer price;

   @Column
   private Date date;

   public Integer getProductId() {
      return productId;
   }

   public void setProductId(Integer productId) {
      this.productId = productId;
   }

   public Integer getPrice() {
      return price;
   }

   public void setPrice(Integer price) {
      this.price = price;
   }

   public Date getDate() {
      return date;
   }

   public void setDate(Date date) {
      this.date = date;
   }

   @Override
   public String toString() {
      return "ProductPrice{" +
             ", productId=" + productId +
             ", price=" + price +
             ", date=" + date +
             '}';
   }
}
