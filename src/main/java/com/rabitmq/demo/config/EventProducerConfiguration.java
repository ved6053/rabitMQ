package com.rabitmq.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rabitmq.demo.service.CustomerService;

import javax.persistence.EntityManager;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

@Configuration
public class EventProducerConfiguration {
 @Autowired
 EntityManager entityManager; 
	 
 @Bean
 public Exchange eventExchange() {
   return new TopicExchange("eventExchange");
 }

 @Bean
 public CustomerService customerService(RabbitTemplate rabbitTemplate, Exchange eventExchange) {
   return new CustomerService(rabbitTemplate, eventExchange);
 }

}
