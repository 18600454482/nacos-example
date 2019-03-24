package com.xiaoy.dubbo.consumer;

import com.xiaoy.dubbo.api.DubboDemoService;
import com.xiaoy.dubbo.consumer.demo.DubboConsumerDemo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DubboConsumerApplication {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public static void main(String[] args) {
        SpringApplication.run(DubboConsumerApplication.class, args);
    }

    @Autowired
    private DubboConsumerDemo dubboConsumerDemo;

    @Bean
    public ApplicationRunner runner() {
        return args -> {
            logger.info(dubboConsumerDemo.demoInvoke("mercyblitz"));
        };
    }
}
