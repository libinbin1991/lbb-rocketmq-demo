package com.example.lbb.rocketmq.springbootproducer.controller;

import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * @author libinbin
 * @version 1.0
 */
@RestController
public class ProducerController {

    @Resource
    private RocketMQTemplate rocketMQTemplate;


    @RequestMapping("/sendSms")
    public void sendSMS(){


        String msg1 = "我是一条消息";

     /*   Message msg = new Message();


        rocketMQTemplate.asyncSend("top1",msg , new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {

            }

            @Override
            public void onException(Throwable throwable) {

            }
        });*/


        SendResult top1 = rocketMQTemplate.syncSend("top1", msg1);

        System.out.println("返回消息："+top1.getMsgId()+top1.getSendStatus());


    }
}
