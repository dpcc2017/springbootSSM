package com.example.springbootSSM.controller;


import com.example.springbootSSM.model.User;
import com.example.springbootSSM.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    private static Logger logger = Logger.getLogger(UserController.class);
    @Autowired
    UserService userService;
    @Autowired
    CacheManager cacheManager;

    @RequestMapping(value = "/insertUser")
    public Map<String, String> insertUser() {
        User user = new User();
        user.setId(6);
        user.setUsername("李明");
       // user.setPassword("123456");
        user.setAge(25);
        userService.insert(user);
        Map<String, String> map = new HashMap<>();
        map.put("mag", "插入成功");
        return map;
    }
@RequestMapping("/selectUser/{id}")
    public Map<String, Object> selectUser(@PathVariable("id") int id) {
      User user= userService.select(id);
    Map<String, Object> map = new HashMap<>();
    map.put("mag", "查询成功");
    map.put("user",user);
    return map;
    }
@RequestMapping("/updateUser")
    public Map<String, String> updateUser(User user) {
        userService.update(user);
    Map<String, String> map = new HashMap<>();
    map.put("mag", "更新成功");
    return map;
    }
@RequestMapping("/deleteUser/{id}")
    public Map<String, String> deleteUser(@PathVariable("id") int id) {
    User user = new User();
    user.setId(id);
        userService.delete(user);
        Map<String, String> map = new HashMap<>();
        map.put("mag", "删除成功");
        return map;
    }
}
