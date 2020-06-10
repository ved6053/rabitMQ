package com.rabitmq.demo.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

import com.rabitmq.demo.domain.Student;
import com.rabitmq.demo.domain.repository.StudentRepository;
import com.rabitmq.demo.model.StudentModel;

public class EventConsumer {

	  private Logger logger = LoggerFactory.getLogger(EventConsumer.class);


	  @Autowired
	  private StudentRepository studentRepository;
	  
	  
	  public EventConsumer() {
		super();
		
		
	}

	@RabbitListener(queues="orderServiceQueue")
	  public void receive(StudentModel model) {
		Student student=new Student();
		student.setName(model.getName());
		student.setTeacherId(model.getTeacherId());
		studentRepository.save(student);
	    logger.info("Received message '{}'", model.getTeacherId()+" "+model.getName());
	  }

	


}