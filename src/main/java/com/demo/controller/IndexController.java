package com.demo.controller;

import ch.qos.logback.core.pattern.color.BoldYellowCompositeConverter;
import com.demo.entity.R;
import com.demo.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/user")
public class IndexController {

    @RequestMapping("/index")
    public Object list(String message) {
        System.out.println("Message : " + message);
        return "index " + message;
    }

    @RequestMapping("/info")
    public Object user() {
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

    @PostMapping("/formData")
    public Object formData(User user) {
        return R.okData(user);
    }

    @RequestMapping("/json")
    public Object json(@RequestBody User user) {
        return R.okData(user);
    }

    @RequestMapping(value = "/raw", method = {RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT})
    public Object raw(@RequestBody String body) {
        return R.okData(body);
    }

}