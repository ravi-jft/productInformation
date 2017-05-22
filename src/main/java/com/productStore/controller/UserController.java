package com.productStore.controller;

import com.productStore.dao.UserDao;
import com.productStore.domain.Users;
import com.productStore.service.UserService;
import com.productStore.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@Controller
@ComponentScan("com.productStore")
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserDao userDao;


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

    /*Forget Password */

    @RequestMapping(value = "/enterEmail",method = RequestMethod.GET)
    public String  enterEmail(){
        return "enterEmail";
    }

    @RequestMapping(value = "/sendLink",method = RequestMethod.POST)
    public String sendLink(@RequestParam("email") String email) {
        Users userInstance = userDao.findByEmail(email);
        System.out.println("========email=========="+email);
        String token = UUID.randomUUID().toString();
        userInstance.setToken(token);
        userDao.save(userInstance);
        userService.Email(email,token);
        return "redirect:/welcome";
    }

    @RequestMapping(value = "/resetLink/{token}")
    public String resetLink(@PathVariable(value = "token") String token){
        System.out.println("====token in resetLink=========="+token);
        Users userInstance = userDao.findByToken(token);
        System.out.println("======userInstance========"+userInstance);
        if (userInstance!=null)
            return "redirect:/user/resetPassword/"+token;
        else {
            System.out.println("invalid password");
            return "redirect:/welcome";
        }
    }

    @RequestMapping(value = "/resetPassword/{token}")
    public String resetPassword(@PathVariable(value = "token") String token, ModelMap model){
        model.addAttribute("token",token);
        return "resetPassword";
    }

    @RequestMapping(value = "/saveResetPassword")
    public String saveResetPassword(@RequestParam("token") String token,@RequestParam("password") String password,@RequestParam("confirmpwd") String confirmpwd){
        System.out.println("======token====="+token);
       Users userInstance = userDao.findByToken(token);
        System.out.println("=======token========"+userInstance);
       /* if (password!=confirmpwd){
            System.out.println("password is not matched");
        }*/

            userInstance.setPassword(password);
            userInstance.setToken(null);
            userDao.save(userInstance);

        return "redirect:/welcome";
    }
}
