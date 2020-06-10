package com.example.lbb.rocketmqbase.web;


import com.example.lbb.rocketmqbase.MQFactory;
import com.example.lbb.rocketmqbase.bean.MQReceive;
import com.example.lbb.rocketmqbase.bean.Response;
import com.example.lbb.rocketmqbase.consumer.MQReceiveCallback;
import com.example.lbb.rocketmqbase.consumer.MQReceiveOrderly;
import com.example.lbb.rocketmqbase.utils.MQEnums;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author libinbin
 * @version 1.0
 */
@RestController
public class Consumer {

    @RequestMapping("/pushSMS")
    public void pushSMS() {

        MQFactory factory = new MQFactory("insurance_bacth", "192.168.192.120:9876");
        MQReceive recive = new MQReceive();
        recive.setTopic("TestTopic1");
        recive.setType(MQEnums.RECEIVE_TYPE.DEFAULT);
        recive.setCallback(new MQReceiveCallback() {
            @Override
            public void callback(List<Response> responses) {
                for (Response response : responses) {

                    System.out.println("push消息" + response.getMsgId() + "  " + response.getObj());
                }
            }

        });
        factory.receiveMsg(recive);

        System.out.println("Consumer Started.");
    }

    @RequestMapping("/pushSMSBatch")
    public void pushSMSBatch() {

        MQFactory factory = new MQFactory("insurance_con", "192.168.192.120:9876");
        MQReceive recive = new MQReceive();
        recive.setTopic("dealEndorseTaskBatch");
        recive.setType(MQEnums.RECEIVE_TYPE.DEFAULT);


        recive.setCallback(new MQReceiveCallback() {
            @Override
            public void callback(List<Response> responses) {
                for (Response response : responses) {


                    System.out.println("push消息" + response.getMsgId() + "  " + response.getObj());
                }
            }

        });
        factory.receiveMsg(recive);

        System.out.println("Consumer Started.");
    }


    @RequestMapping("/pushSMSOdery")
    public void pushSMSOdery() {

        MQFactory factory = new MQFactory("insurance_con", "192.168.192.120:9876");
        MQReceive recive = new MQReceive();
        recive.setTopic("dealEndorseTask");
        recive.setType(MQEnums.RECEIVE_TYPE.ORDERLY);
        recive.setOrderlyCallBack(new MQReceiveOrderly() {

            @Override
            public void callback(List<Response> responses) {
                for (Response response : responses) {


                    System.out.println("pushOrdery消息" + response.getMsgId());

                }
            }
        });
        factory.receiveMsg(recive);

        System.out.println("Consumer Started.");
    }


}