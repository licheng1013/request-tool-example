package com.demo.entity;

import lombok.Data;

import java.util.ArrayList;

@Data
public class User {
    private Integer id;
    private String name;
    private String password;
    private String nickName;
    private String email;

    public static User of() {
        User user = new User();
        user.setId(1);
        user.setName("admin");
        user.setPassword("123456");
        user.setNickName("管理员");
        user.setEmail("xxx@qq.com");
        return user;
    }

    public static Object list() {
        var list = new ArrayList<User>();
        for (int i = 1; i <= 10; i++) {
            User user = User.of();
            user.id = i;
            list.add(user);
        }
        return list;
    }
}
