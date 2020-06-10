package com.example.lbb.rocketmqbase.web;


import com.example.lbb.rocketmqbase.MQFactory;
import com.example.lbb.rocketmqbase.bean.MQSend;
import com.example.lbb.rocketmqbase.utils.MQEnums;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author libinbin
 * @version 1.0
 */
@RestController
public class Producer {


    @GetMapping("/sendSMS")
    public void sendSMS() {
        MQFactory factory = new MQFactory("insurance", "192.168.192.120:9876");
        MQSend send = new MQSend();
        send.setTopic("TestTopic1");
        send.setMsgBody("This is a message~balalala");
        send.setType(MQEnums.SEND_TYPE.DEFAULT);
        factory.sendMsg(send);
    }
}