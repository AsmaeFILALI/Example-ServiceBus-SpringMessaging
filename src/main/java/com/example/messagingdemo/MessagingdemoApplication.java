package com.example.messagingdemo;

import com.azure.spring.messaging.implementation.annotation.EnableAzureMessaging;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
@EnableAzureMessaging
@ImportAutoConfiguration(com.azure.spring.cloud.autoconfigure.implementation.messaging.AzureMessagingListenerAutoConfiguration.class)
public class MessagingdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessagingdemoApplication.class, args);
	}

}
