package com.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.entity.Student;

public interface studentResository extends JpaRepository<Student, Long>{
	
	//Custom method
 public Student findByfNameAndLName(String fName, String lName );
  //Native Query
 
 
 //JPQL Query
}
