package com.rabitmq.demo.config;

import javax.persistence.EntityManager;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rabitmq.demo.service.EventConsumer;

@Configuration
public class EventConsumerConfiguration {

	
  @Bean
  public Queue queue() {
    return new Queue("orderServiceQueue");
  }
  
  @Bean
  public Binding binding(Queue queue, Exchange eventExchange) {
    return BindingBuilder
            .bind(queue)
            .to(eventExchange)
            .with("customer.*").noargs();
  }

  @Bean
  public EventConsumer eventReceiver() {
    return new EventConsumer();
  }

}
