package com.example.msactuator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("new")
public class NewController {


    //@RequestMapping(value = {"/getId/{name}","/getId/{name}/{id}"})
    @RequestMapping("/getId")
    public @ResponseBody String helloThere(@RequestParam(required = false) String name,@RequestParam(required = false) String id){
        if("Avkash".equalsIgnoreCase(name)){
            return "Your Id is 592";
        }else if ("592".equalsIgnoreCase(id)){
            return "Avkash" ;
        }
        return "No id found";
    }

}
