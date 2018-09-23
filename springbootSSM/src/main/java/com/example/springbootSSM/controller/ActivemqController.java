package com.example.springbootSSM.controller;

import com.alibaba.fastjson.JSON;
import com.example.springbootSSM.activeMq.Producer;
import com.example.springbootSSM.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Topic;
import java.util.HashMap;
import java.util.Map;
@RestController
@RequestMapping("/activemq")
public class ActivemqController {
    @Autowired
    Producer producer;
    @Autowired
    Topic topic;
    @RequestMapping("/sendMsg")
    public Map<String, Object> sendMessage(User user) {
        producer.sendMessage(topic, JSON.toJSONString(user));
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "发送消息成功");
        return map;
    }
}
