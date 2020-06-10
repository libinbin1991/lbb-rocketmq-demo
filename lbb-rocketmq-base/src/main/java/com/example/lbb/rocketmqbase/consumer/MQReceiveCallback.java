package com.example.lbb.rocketmqbase.consumer;


import com.example.lbb.rocketmqbase.bean.Response;
import com.example.lbb.rocketmqbase.utils.SerializeUtils;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.ArrayList;
import java.util.List;

public abstract class MQReceiveCallback implements MessageListenerConcurrently {


    public abstract void callback(List<Response> responses);

    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> paramList,
                                                    ConsumeConcurrentlyContext paramConsumeConcurrentlyContext) {
        try {
            List<Response> respones = new ArrayList<Response>();
            for (MessageExt ext : paramList) {
                Response response = new Response();
                response.setMsgId(ext.getMsgId());
                response.setObj(SerializeUtils.unSerialObjInBean(ext.getBody(), Object.class));
                respones.add(response);
            }
            callback(respones);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }

}
