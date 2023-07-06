package com.example.messagingdemo.serviceBus;

import com.azure.spring.messaging.servicebus.implementation.core.annotation.ServiceBusListener;
import com.example.messagingdemo.MenuOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ServiceBusConsumer {


    @Autowired
    ActionService actionService;

    ObjectMapper objectMapper = new ObjectMapper();

    private static final String QUEUE_NAME = "<queue name>";

    @ServiceBusListener(destination = QUEUE_NAME)
    public void handleMessageFromServiceBus(String message) throws JsonProcessingException {
        MenuOrder menuOrder = objectMapper.readValue(message, MenuOrder.class);
       log.info("*******************Service Bus Message Recieved {} ", menuOrder.toString());
       actionService.performAction(menuOrder);
    }



}
