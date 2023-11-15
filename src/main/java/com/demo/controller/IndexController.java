package com.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/user")
public class IndexController {

    @RequestMapping("/index")
    public Object list(String message) {
        System.out.println("Message : " + message);
        return "index " + message;
    }

    @RequestMapping("/json")
    public Object json(String message) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("message", message);
        return map;
    }
}