package com.example.lbb.rocketmq.springbootconsumer;

import com.example.lbb.rocketmq.springbootconsumer.annotation.EnableRocketMq;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableRocketMq
public class LbbRocketmqSpringbootConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LbbRocketmqSpringbootConsumerApplication.class, args);
    }

}
