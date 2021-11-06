package com.example.jpademo.user.controller;


import com.example.jpademo.user.model.User;
import com.example.jpademo.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class RestCntrl{

    @Resource
    UserService userService;


    @GetMapping("/getUser")
    public ResponseEntity<User> getUser(@RequestParam(required = false) Integer id){
        User user =  userService.FindUserById(id);
        return ResponseEntity.ok(user);
    }
}
