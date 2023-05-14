package com.zbb.kafka.simple;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class ConsumerQuickStart {

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"192.168.221.132:9092"); //kafka地址
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringDeserializer"); //kafka地址
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringDeserializer"); //kafka地址
        props.put(ConsumerConfig.GROUP_ID_CONFIG,"helloGroup"); //消费组

        //创建消费者对象
        KafkaConsumer kafkaConsumer = new KafkaConsumer(props);

        //监听主题
        kafkaConsumer.subscribe(Collections.singleton("hello"));
        ConsumerRecords<String,String> records = kafkaConsumer.poll(Duration.ofSeconds(2));//每隔2秒拉取1次
        //遍历消息
        for(ConsumerRecord<String,String> record:records){
            String key = record.key();
            String value = record.value();
            System.out.println(key+"---"+value);
        }
//        //接受消息
//        while(true){
//
//        }
    }
}
