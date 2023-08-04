package com.example.messagingdemo.serviceBus;

import com.example.messagingdemo.MenuOrder;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/serviceBus")
public class ServiceBusDemoController {
    @Autowired
    ServiceBusProducer serviceBusProducer;

    @PostMapping(value = "/senderQueue1")
    public String producerQ1(@RequestBody MenuOrder menuOrder) throws JsonProcessingException {
        serviceBusProducer.SendMsgQ1(menuOrder);
        return "Message sent to supplier senderQueue1";
    }

    @PostMapping(value = "/senderQueue2")
    public String producer2(@RequestBody MenuOrder menuOrder) throws JsonProcessingException {
        serviceBusProducer.SendMsgQ2(menuOrder);
        return "Message sent to supplier senderQueue2";
    }


        @PostMapping(value = "/senderQueue1Loop")
    public String producerQ1Loop(@RequestBody MenuOrder menuOrder) throws JsonProcessingException {

        CompletableFuture.runAsync(()->{
            try {
                serviceBusProducer.SendMsgQ1Loop(menuOrder);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        });
       
        
        
        return "Message sent to supplier senderQueue1";
    }
}
