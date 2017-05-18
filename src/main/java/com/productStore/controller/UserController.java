package com.productStore.controller;

import com.productStore.domain.Users;
import com.productStore.service.UserService;
import com.productStore.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@ComponentScan("com.productStore")
@RequestMapping(value = "/user")
public class UserController {


  /*  @Qualifier("UserServiceImpl")*/
    @Autowired
    private UserService userService;

   /* UserService userService = new UserServiceImpl();*/

   // @Secured("ROLE_ADMIN")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome(){
        return "welcome";
    }

 //   @Secured("ROLE_ADMIN")
    //@Secured("permitAll")
    @RequestMapping(value = "/saveOrUpdate",method = RequestMethod.POST,headers = "Accept=application/json")
    public String saveOrUpdate(@ModelAttribute("user") @Valid Users user){
        System.out.println("=====in user controller======");

        userService.addUser(user);
       // Users users = userService.findByUsername(user.getUsername()); //getting save user
        /*Roles roles = userService.findByAuthority("ROLE_USER");
        User*/
        return "redirect:/welcome";
    }

   /* @Secured("ROLE_ADMIN")*/
    @RequestMapping(value = "/create",method = RequestMethod.GET)
    public String create(){
        return "create";
    }

}