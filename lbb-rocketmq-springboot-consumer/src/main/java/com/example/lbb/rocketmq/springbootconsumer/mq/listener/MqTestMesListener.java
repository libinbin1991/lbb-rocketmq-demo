package com.example.lbb.rocketmq.springbootconsumer.mq.listener;

import com.example.lbb.rocketmq.springbootconsumer.annotation.RocketMqListener;
import com.example.lbb.rocketmq.springbootconsumer.enums.MqAction;
import com.example.lbb.rocketmq.springbootconsumer.mq.MessageListener;
import com.example.lbb.rocketmq.springbootconsumer.mq.command.MqConstant;
import com.example.lbb.rocketmq.springbootconsumer.util.MqMsgConvertUtil;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Sunshine Insurance Group Co., Ltd.</p>
 *
 * @author lbb
 * @version 1.0
 * 修改记录：
 * 修改序号，修改日期，修改人，修改内容
 */
@RocketMqListener(topic = MqConstant.Top.TOP1, consumerGroup = MqConstant.ConsumeGroup.TEST1_GROUP)
public class MqTestMesListener implements MessageListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(MqTestMesListener.class);
    @Override
    public MqAction consume(MessageExt message, ConsumeConcurrentlyContext context) {
        String msg = null;

        msg = MqMsgConvertUtil.bytes2String(message.getBody(), "UTF-8");

        LOGGER.info("MsgId:{},MQ消费,Topic:{},Tag:{}，Body:{}", message.getMsgId(),
                message.getTopic(), message.getTags(), msg);

        return MqAction.CommitMessage;
    }
}
