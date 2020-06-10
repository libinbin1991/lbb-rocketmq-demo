package com.example.lbb.rocketmqbase.bean;


import com.example.lbb.rocketmqbase.consumer.MQReceiveCallback;
import com.example.lbb.rocketmqbase.consumer.MQReceiveOrderly;
import com.example.lbb.rocketmqbase.utils.MQEnums;

public class MQReceive extends BaseBean {


    private MQReceiveOrderly orderlyCallBack;
    private MQReceiveCallback callback;
    private MQEnums.RECEIVE_TYPE type;

    public MQReceiveCallback getCallback() {
        return callback;
    }

    public void setCallback(MQReceiveCallback callback) {
        this.callback = callback;
    }

    public MQEnums.RECEIVE_TYPE getType() {
        return type;
    }

    public void setType(MQEnums.RECEIVE_TYPE type) {
        this.type = type;
    }

    public MQReceiveOrderly getOrderlyCallBack() {
        return orderlyCallBack;
    }

    public void setOrderlyCallBack(MQReceiveOrderly orderlyCallBack) {
        this.orderlyCallBack = orderlyCallBack;
    }


}
