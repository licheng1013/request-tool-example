package com.demo.controller;

import com.demo.entity.R;
import com.demo.entity.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

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

    @RequestMapping("/urlEncoded")
    public Object urlEncoded(User user) {
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


    @PostMapping("/file")
    public Object file(@RequestParam("file") MultipartFile file) throws IOException {
        // 保存到项目下
        System.out.println("文件上传: "+file.getOriginalFilename());
        file.transferTo(new File("D:\\my-study\\request-tool-example\\"+file.getOriginalFilename()));
        return R.okData(file.getOriginalFilename());
    }

}