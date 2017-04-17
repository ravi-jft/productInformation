package com.productStore.controller;

import com.productStore.domain.Product;
import com.productStore.service.ProductService;
import com.productStore.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@ComponentScan("com.productStore")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/")
    public String index()   {
        return "index";
    }

    @RequestMapping(value = "/saveOrUpdate", method = RequestMethod.POST,headers = "Accept=application/json")
    public String saveOrUpdate(@ModelAttribute("product") Product product){
        System.out.println("=========I am in save method controller=======");
        productService.addProduct(product);
        return "redirect:/getAllProducts";
    }

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
