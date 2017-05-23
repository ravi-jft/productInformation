package com.productStore.controller;

import com.productStore.service.Abc;
import com.productStore.service.CheckAspectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@ComponentScan("com.productStore")
@RequestMapping(value = "/AOPExample")
//@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AOPExampleTest {
    @Autowired
    private CheckAspectService checkAspectService;

    Abc abc = new Abc();

    @RequestMapping(value = "/some",method = RequestMethod.GET)
    public void testSomething(){
        checkAspectService.sayHi();
        checkAspectService.sayBye();
    }

    @RequestMapping(value = "/some1", method = RequestMethod.GET)
    public void check(){
     abc.d();
    }
}
