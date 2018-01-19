package com.gsafety.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
    //系统登录
    @RequestMapping(value = "/login" ,method = RequestMethod.GET)
    public String getlogin(){
        return "user/login";
    }
}
