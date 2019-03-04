package com.tools.utils.rabbit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author leike
 * @date 2019/3/3 12:45
 */
public class MqServer {

    public static void main(final String... args) throws Exception {
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext(
                "classpath:spring/applicationContext-RabbitMQ.xml");
        //RabbitMQ模板
        RabbitTemplate template = ctx.getBean(RabbitTemplate.class);
        //发送消息
        template.convertAndSend("Hello, world!");
        // 休眠1秒
        Thread.sleep(1000);
        //容器销毁
        ctx.destroy();
    }

}
