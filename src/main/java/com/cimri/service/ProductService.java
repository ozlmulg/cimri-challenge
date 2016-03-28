package com.cimri.service;
 /**
 * @author ozlem
 */

import com.cimri.entity.Product;
import java.util.List;
import javax.sql.DataSource;

public interface ProductService {
    /**
     * This is the method to be used to initialize
     * database resources ie. connection.
     */
    void setDataSource(DataSource ds);
    /**
     * This is the method to be used to create
     * a record in the Product table.
     */
    void addProduct(Product product);
    /**
     * This is the method to be used to create
     * multiple records in the Product table.
     */
    void insertBatch(final List<Product> products);
    /**
     * This is the method to be used to list down
     * a record from the Product table corresponding
     * to a passed student id.
     */
    Product getProduct(Integer id);
    /**
     * This is the method to be used to list down
     * all the records from the Product table.
     */
    List<Product> getProductsLikeTitle(String title);

    void readXml(String fileUrl);
}
