package com.example.msactuator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @RequestMapping(value = "/page1",method = RequestMethod.GET)
    public String login(){
        return "{'username':avkash.hirpara,'password : *********'}";
    }
}
