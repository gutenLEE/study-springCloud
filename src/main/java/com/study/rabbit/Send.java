package com.study.rabbit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.impl.ChannelN;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

@Profile("send")
public class Send {
    static Logger logger = LoggerFactory.getLogger(Send.class);

    private static String QUEUE_NAME = "hello2";

    public static void main(String[] argv) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        String message = "welcome to RabbitMQ";

        channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));
        logger.info("[!] send " + message + "'");
        channel.close();
        connection.close();
    }

}
