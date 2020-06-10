package com.rabitmq.demo.service;


import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.rabitmq.demo.domain.Teacher;
import com.rabitmq.demo.domain.repository.TeacherRepository;
import com.rabitmq.demo.model.StudentModel;


public class CustomerService {
	 private final RabbitTemplate rabbitTemplate;

	  private final Exchange exchange;


	
	  @Autowired
	  private TeacherRepository teacherRepository;
	  
	  
	  public CustomerService(RabbitTemplate rabbitTemplate, Exchange exchange) {
	    this.rabbitTemplate = rabbitTemplate;
	    this.exchange = exchange;
	   
	  }


	public void createCustomer() {
	    // ... do some database stuff
	    String routingKey = "customer.created";
	    String message = "customer created";
	    Teacher teacher=new Teacher("SKSINGH");
	    teacherRepository.save(teacher);
	    StudentModel model=new StudentModel();
	    model.setName("abhisek");
	    model.setTeacherId(teacher.getId());
	    
	    rabbitTemplate.convertAndSend(exchange.getName(), routingKey, model);
	  }



}
