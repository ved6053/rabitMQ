package com.rabitmq.demo.model;

import java.io.Serializable;

public class StudentModel implements Serializable{

	Integer teacherId;
	String name;

	public StudentModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	
}
