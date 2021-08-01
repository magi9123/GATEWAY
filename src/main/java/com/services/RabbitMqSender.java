package com.services;

import com.models.user.UserCurrencyAbstract;
import org.slf4j.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class RabbitMqSender {

    private static final Logger logger = LoggerFactory.getLogger(RabbitMqSender.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${spring.rabbitmq.exchange}")
    private String exchange;

    @Value("${spring.rabbitmq.routingkey}")
    private String routingKey;

    public void send(UserCurrencyAbstract user) {
        rabbitTemplate.convertAndSend(exchange, routingKey, user);
    }
}
