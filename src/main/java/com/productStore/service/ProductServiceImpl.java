package com.productStore.service;

import com.productStore.dao.ProductDao;
import com.productStore.domain.Product;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created by ravi on 13/4/17.
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    public void addProduct(Product product) {
        productDao.addCountry(product);
    }

    public List getAllProducts() {
        return productDao.getAllProducts();
    }

}