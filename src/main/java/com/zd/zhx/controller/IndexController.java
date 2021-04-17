package com.zd.zhx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String hello(){
        /*System.out.println(1);*/
        return "index";
    }

}
