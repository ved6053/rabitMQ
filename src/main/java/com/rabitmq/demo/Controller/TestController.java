package com.rabitmq.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rabitmq.demo.service.CustomerService;

@RestController
public class TestController {
	@Autowired
	CustomerService customerService;
	
	@GetMapping("produce")
	public ResponseEntity<?> producer(){
		customerService.createCustomer();
		return new ResponseEntity<>("Messages Produced", HttpStatus.OK);
	}

}
