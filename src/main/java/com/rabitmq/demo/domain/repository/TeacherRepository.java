package com.rabitmq.demo.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.rabitmq.demo.domain.Teacher;

public interface TeacherRepository extends CrudRepository<Teacher,Integer>{

	

}
