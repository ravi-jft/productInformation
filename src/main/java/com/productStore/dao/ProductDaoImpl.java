package com.productStore.dao;

import com.productStore.domain.Product;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by ravi on 13/4/17.
 */

@Repository
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

 /*   @Transactional
    public Product addCountry(Product product) {
       *//* Session session = this.sessionFactory.getCurrentSession();
        session.persist(product);
        session.close();*//*
       // Session session= sessionFactory.openSession();
    //  sessionFactory.getCurrentSession().saveOrUpdate(product);
      // Transaction transaction =  session.beginTransaction();
       // session.saveOrUpdate(product);
       // transaction.commit();
       // session.close();
       // System.out.println("=============I am in addCountry DaoImpl2========");
        System.out.println(hibernateTemplate.save(product)+"--------------------------");
        return null;
    }*/
 @Transactional
 public void addCountry(Product product) {
     hibernateTemplate.save(product);
 }

    public List getAllProducts() {
        //Session session = this.sessionFactory.getCurrentSession();

       //List<Product> productList = session.createCriteria(Product.class).list();
        List<Product> productList = (List<Product>) hibernateTemplate.findByCriteria(DetachedCriteria.forClass(Product.class));

        return productList;
    }

}
