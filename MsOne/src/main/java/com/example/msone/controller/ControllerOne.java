package com.example.msone.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ControllerOne {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    EurekaClient eurekaClient;

    @RequestMapping("/user")
    public ResponseEntity<Map> getUserData(@RequestParam(required = false) Integer userId){
        Map<String,Object> map = new HashMap<>();
        map.put("serId",1);
        map.put("userName","Avkash");
        map.put("age",32);
                //"{'Userid':1,'userName':'Avkash','age':34}"
        return ResponseEntity.ok(map);
    }
    @RequestMapping("/users")
    public String getUsersData(@RequestParam(required = false) Integer userId){
        Map<String,Object> map = new HashMap<>();
        map.put("serId","1");
        map.put("userName","Avkash");
        map.put("age",32);
        //"{'Userid':1,'userName':'Avkash','age':34}"
        return map.toString();
    }
    @RequestMapping("/getUser")
    public ResponseEntity<User> getUserFromJpaApplication(@RequestParam(required = false) Integer userId){

        //ResponseEntity<User> user =  restTemplate.getForEntity("http://localhost:8081/getUser?id=3", User.class);

        Application application = eurekaClient.getApplication("JPADEMO");
        InstanceInfo instanceInfo = application.getInstances().get(0);
        System.out.println("http://"+instanceInfo.getIPAddr()+":"+instanceInfo.getPort()+"/getUser?id=3");
        ResponseEntity<User> user =  restTemplate.getForEntity("http://"+instanceInfo.getIPAddr()+":"+instanceInfo.getPort()+"/getUser?id=3", User.class);

//        User u = user.getBody();
//        Map<String,Object> map = new HashMap<>();
//        map.put("serId",u.getId());
//        map.put("userName",u.getUserName());
//        map.put("age",u.getAge());
        //"{'Userid':1,'userName':'Avkash','age':34}"
        return user;
    }

}
