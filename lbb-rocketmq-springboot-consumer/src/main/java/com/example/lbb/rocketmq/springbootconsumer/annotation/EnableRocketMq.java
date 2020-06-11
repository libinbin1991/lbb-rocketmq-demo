package com.example.lbb.rocketmq.springbootconsumer.annotation;


import com.example.lbb.rocketmq.springbootconsumer.config.RocketMqFactoryBeanConfig;
import com.example.lbb.rocketmq.springbootconsumer.config.RocketMqProperties;
import com.example.lbb.rocketmq.springbootconsumer.mq.RocketMqConsumerRunner;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 启用mq 注解
 *
 * @author lizhuo
 * @since 2020/3/17 15:25
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({
    RocketMqProperties.class,
    RocketMqConsumerRunner.class,
    RocketMqFactoryBeanConfig.class
})
public @interface EnableRocketMq {

}