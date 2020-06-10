package com.rabitmq.demo.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rabitmq.demo.domain.Student;

public interface StudentRepository extends JpaRepository<Student,Integer>{

}
