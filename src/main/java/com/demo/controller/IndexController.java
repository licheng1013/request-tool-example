package com.demo.controller;

import com.demo.entity.R;
import com.demo.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
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
        return R.okData(message);
    }

    @RequestMapping("/one")
    public Object user(HttpServletRequest request) {
        // 获取所有请求头
        HashMap<String, String> map = new HashMap<>();
        request.getHeaderNames().asIterator().forEachRemaining(key -> {
            map.put(key, request.getHeader(key));
        });
        return R.okData(User.of());
    }

    @RequestMapping("/header")
    public Object header(HttpServletRequest request) {
        // 获取所有请求头
        HashMap<String, String> map = new HashMap<>();
        request.getHeaderNames().asIterator().forEachRemaining(key -> {
            map.put(key, request.getHeader(key));
        });
        return R.okData(map);
    }
}