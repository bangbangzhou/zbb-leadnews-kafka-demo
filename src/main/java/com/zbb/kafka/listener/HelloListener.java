package com.zbb.kafka.listener;

import com.alibaba.fastjson.JSON;
import com.zbb.kafka.entity.User;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class HelloListener {
    @KafkaListener(topics = "boot")
    public void handleHello1(ConsumerRecord<String,String> record){
        String key = record.key();
        String value = record.value();
        System.out.println(key+"---"+value);
    }

    /**
     * 只接收value
     * @param value
     */
    @KafkaListener(topics = "boot2")
    public void handleHello2(String value){
        System.out.println(value);
    }

    /**
     * 接收对象
     * @param value
     */
    @KafkaListener(topics = "boot3")
    public void handleHello3(String value){
        //转为对象
        User user = JSON.parseObject(value, User.class);
        System.out.println("username:"+user.getUsername()+",age:"+user.getAge());
    }
}
