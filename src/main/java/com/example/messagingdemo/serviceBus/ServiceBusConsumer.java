package com.example.messagingdemo.serviceBus;

import com.azure.spring.messaging.servicebus.implementation.core.annotation.ServiceBusListener;
import com.example.messagingdemo.MenuOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.*;

@Slf4j
@Component
public class ServiceBusConsumer {


    @Autowired
    ActionService actionService;

    ObjectMapper objectMapper = new ObjectMapper();

    private static final String QUEUE1_NAME = "demoqueue";
    private static final String QUEUE2_NAME = "queueaks";


   @ServiceBusListener(destination = QUEUE1_NAME)
   public void handleMessageFromServiceBusQ1(String message) throws JsonProcessingException {
       MenuOrder menuOrder = objectMapper.readValue(message, MenuOrder.class);
      log.info("*******************Service Bus Message Recieved on {} {} ", QUEUE1_NAME,menuOrder.toString());
      actionService.performAction(menuOrder);
   }


   @ServiceBusListener(destination = QUEUE2_NAME)
   public void handleMessageFromServiceBusQ2(String message) throws JsonProcessingException {
       MenuOrder menuOrder = objectMapper.readValue(message, MenuOrder.class);
       log.info("*******************Service Bus Message Recieved on {} {} ", QUEUE2_NAME,menuOrder.toString());
       actionService.performAction(menuOrder);
   }


}
