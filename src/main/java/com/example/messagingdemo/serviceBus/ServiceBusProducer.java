package com.example.messagingdemo.serviceBus;

import com.azure.spring.messaging.servicebus.core.ServiceBusTemplate;
import com.example.messagingdemo.MenuOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class ServiceBusProducer {


    @Autowired
    private ServiceBusTemplate serviceBusTemplate;

    ObjectMapper objectMapper = new ObjectMapper();

    private static final String QUEUE_NAME = "<queue name>";

    public void SendMsg(MenuOrder menuOrder) throws JsonProcessingException {
        serviceBusTemplate.sendAsync(QUEUE_NAME, MessageBuilder.withPayload(objectMapper.writeValueAsString(menuOrder)).build()).subscribe();
        log.info("*******************ServiceBUS_MessageSent************: {}", menuOrder.toString());
    }


}



