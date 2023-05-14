package com.zbb.kafka.controller;

import com.alibaba.fastjson.JSON;
import com.zbb.kafka.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    /**
     * 普通消费发现
     */
    @GetMapping("/hello1")
    public String hello1(){
        kafkaTemplate.send("boot","1001","hello springboot kafka!");
        return "发送成功";
    }

    /**
     * 消息只发送value值，不发key
     * @return
     */
    @GetMapping("/hello2")
    public String hello2(){
        kafkaTemplate.send("boot2","Only value");
        return "发送成功";
    }

    /**
     * 消息发送对象
     * @return
     */
    @GetMapping("/hello3")
    public String hello3(){
        User user = new User("如花",18);
        //转换json字符串
        String json = JSON.toJSONString(user);
        kafkaTemplate.send("boot3",json);
        return "发送成功";
    }
}
