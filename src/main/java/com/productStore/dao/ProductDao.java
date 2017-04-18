package com.productStore.dao;

import com.productStore.domain.Product;

import java.util.List;

/**
 * Created by ravi on 13/4/17.
 */
public interface ProductDao {
    /*public Product addCountry(Product product);*/
     public void addCountry(Product product);
     public List getAllProducts();
}
