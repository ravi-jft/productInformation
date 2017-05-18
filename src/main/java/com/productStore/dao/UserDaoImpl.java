package com.productStore.dao;

import com.productStore.domain.Roles;
import com.productStore.domain.Users;
import com.productStore.domain.Roles;
import com.productStore.domain.Users;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ravi on 9/5/17.
 */

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private HibernateTemplate hibernateTemplate;
 /*   HibernateTemplate hibernateTemplate = new HibernateTemplate();*/

   /* @Transactional*/
   /* @Override
    public void addUser(Users user) {
       // user.setRoleses("ROLE_USER");;
       // user.setRoleses(new HashSet<>(0));
        //user.setRoleses(new HashSet<>(userDao.findByAuthority("ROLE_USER")));
        //user.setRoleses(new HashSet<>(userDao.findByAuthority()));
        System.out.println("nnnnnnnnn==" + hibernateTemplate);
        System.out.println("==username=========="+user.getUsername());
        System.out.println("==email=========="+user.getEmail());
        System.out.println("==password=========="+user.getPassword());
        hibernateTemplate.save(user);
    }*/

    @Override
    @Transactional(readOnly = false)
    public void addUser(Users user) {
        System.out.println("===nnnnnn===="+hibernateTemplate);
        System.out.println("====username======"+user.getUsername());
       // System.out.println("====email============"+user.getEmail());
        System.out.println("=====password==========="+user.getPassword());
        hibernateTemplate.save(user);
    }

    @Override
    public Users findByUsername(String username) {
        return  (Users) hibernateTemplate.findByCriteria(
                DetachedCriteria.forClass(Users.class)
                        .add(Restrictions.eq("username", username))).get(0);
    }

    @Override
    public Users findByEmail(String email) {
        return  (Users) hibernateTemplate.findByCriteria(
                DetachedCriteria.forClass(Users.class)
                        .add(Restrictions.eq("email", email))).get(0);
    }

    @Override
    public Roles findByAuthority(String role) {
        return (Roles)hibernateTemplate.findByCriteria(DetachedCriteria.forClass(Roles.class)
        .add(Restrictions.eq("name",role))).get(0);
    }

}
