package com.productStore.service;

import com.productStore.dao.ProductDao;
import com.productStore.domain.Product;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created by ravi on 13/4/17.
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Autowired
    //JavaMailSender mailSender;
    MailSender mailSender;

    public void addProduct(Product product) {
        productDao.addCountry(product);
    }

    public List getAllProducts() {
        return productDao.getAllProducts();
    }

    public void sendSimpleEmail(){
        SimpleMailMessage message = new SimpleMailMessage();
        System.out.println("=========I am in email method 1=====");
        message.setTo("ravi.kumar@jellyfishtechnologies.com");
        message.setSubject("Hi Ravi! First Spring MVC Mail");
        System.out.println("=========I am in email method 2=====");
        message.setText("I am sent first spring MVC email");
        System.out.println("=========I am in email method 3=====");
        mailSender.send(message);
    }

}