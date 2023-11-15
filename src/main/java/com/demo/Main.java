package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @RestController
    static class IndexController {
        @RequestMapping("/index")
        public Object list(String message) {
            System.out.println("Message : "+message);
            return "index " + message;
        }

        @RequestMapping("/json")
        public Object json(String message){
            HashMap<String, Object> map = new HashMap<>();
            map.put("code",0);
            map.put("message",message);
            return map;
        }
    }
}