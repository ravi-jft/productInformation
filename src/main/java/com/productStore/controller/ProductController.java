package com.productStore.controller;

import com.productStore.domain.Product;
import com.productStore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Controller
@ComponentScan("com.productStore")

public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    MessageSource messageSource;
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST,headers = "Accept=application/json")
    public String saveOrUpdate(@ModelAttribute("product") @Valid Product product,BindingResult result,Model model){
        if (result.hasErrors()){
           result.getAllErrors().forEach(objectError -> {
               System.out.println(objectError);
           });
            /*model.addAttribute("product");*/
                return "index";
        }
        productService.addProduct(product);
        return "redirect:/getAllProducts";
    }
    @RequestMapping(value = "product",method = RequestMethod.GET)
    public Product product(){
        return new Product();
    }

   /* @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST,headers = "Accept=application/json")
    public ModelAndView saveOrUpdate(@ModelAttribute("product") @Valid Product product,BindingResult result){
        ModelAndView model;
        if (result.hasErrors()){
            return new ModelAndView("index");
        }
        productService.addProduct(product);
        model = new ModelAndView("redirect:/getAllProducts");
        return model;
    }*/

    @RequestMapping(value = "/getAllProducts", headers = "Accept=application/json")
    public String getProducts(Model model){
        List listOfProducts = productService.getAllProducts();
        model.addAttribute("product",new Product());
        model.addAttribute("listOfProducts",listOfProducts);
        return "productDetails";
    }
   /* @RequestMapping("/products")
    public String list(Model model){
     //   model.addAllAttributes("products",prou)
    }*/
}
