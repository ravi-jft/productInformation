package com.productStore.service;

import com.productStore.domain.Product;

import java.util.List;

/**
 * Created by ravi on 13/4/17.
 */
public interface ProductService {

    void addProduct(Product product);
    List getAllProducts();

    public void sendSimpleEmail();
}
