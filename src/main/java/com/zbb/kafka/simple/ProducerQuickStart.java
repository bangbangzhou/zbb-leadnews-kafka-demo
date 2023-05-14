package com.zbb.kafka.simple;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class ProducerQuickStart {

    public static void main(String[] args) {

        //设置参数
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"192.168.221.132:9092");//kafka地址
        //key序列化类
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,"org.apache.kafka.common.serialization.StringSerializer");//value序列化类

        //创建生产者对象
        KafkaProducer<String,String> kafkaProducer = new KafkaProducer<String, String>(props);

        //创建消息对象
        /**
         * 参数一：主题名称（topic)
         * 参数二：key
         * 参数三：value
         */
        ProducerRecord<String,String> msg = new ProducerRecord<>("hello","1001","hello kafka!!!");

        //利用生产者对象发送消息
        kafkaProducer.send(msg);

        //释放连接
        kafkaProducer.close();

    }
}
