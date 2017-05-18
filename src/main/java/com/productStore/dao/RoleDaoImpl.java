package com.productStore.dao;

import com.productStore.domain.Roles;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl implements RoleDao {

    /*HibernateTemplate hibernateTemplate = new HibernateTemplate();*/
    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public Roles findByRole(String role) {
        System.out.println("========in RoleDaoImpl===="+hibernateTemplate);
        return (Roles)hibernateTemplate.findByCriteria(DetachedCriteria.forClass(Roles.class)
                .add(Restrictions.eq("name",role))).get(0);
    }



}
