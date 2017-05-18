package com.productStore.service;

import com.productStore.dao.RoleDao;
import com.productStore.dao.RoleDaoImpl;
import com.productStore.dao.UserDao;
import com.productStore.dao.UserDaoImpl;
import com.productStore.domain.Roles;
import com.productStore.domain.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;


/**
 * Created by ravi on 11/5/17.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    //JavaMailSender mailSender;
            MailSender mailSender;

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Override
    public void addUser(Users user) {
        System.out.println("=====in UserServiceImpl=========");
        System.out.println("======roleDao======="+ roleDao);
        Roles userRole = roleDao.findByRole("ROLE_ADMIN");
        System.out.println("=======userRole========="+userRole);
        user.setRoles(new HashSet<>(Arrays.asList(userRole)));
        userDao.addUser(user);
    }

    @Override
    public Users findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public void Email(String email,String token) {
        SimpleMailMessage message = new SimpleMailMessage();
        System.out.println("=========I am in email method 1=====");
        message.setTo(email);
        message.setSubject("Hi Ravi! Reset your password");
        System.out.println("=========I am in email method 2=====");
        String url=
        message.setText("I am sent first spring MVC email");

        System.out.println("=========I am in email method 3=====");
        mailSender.send(message);
    }

   /*

    public void sendSimpleEmail(){
        SimpleMailMessage message = new SimpleMailMessage();
        System.out.println("=========I am in email method 1=====");
        message.setTo("ravi.kumar@jellyfishtechnologies.com");
        message.setSubject("Hi Ravi! First Spring MVC Mail");
        System.out.println("=========I am in email method 2=====");
        message.setText("I am sent first spring MVC email");
        System.out.println("=========I am in email method 3=====");
        mailSender.send(message);
    }*/
}
