package com.study.rabbit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitApplication {

    //private final static String QUEUE_NAME = "hello";

    static Logger logger = LoggerFactory.getLogger(RabbitApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(RabbitApplication.class, args);
    }

}
