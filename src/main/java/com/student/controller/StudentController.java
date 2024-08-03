package com.student.controller;

import java.security.PublicKey;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.entity.Student;
import com.student.service.StudentService;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/student")
public class StudentController {
@Autowired

private  StudentService studentService;
@PostMapping("/create")
public Student createStudent(@Valid @RequestBody Student student)
{
	return studentService.createData(student);
	
}

//GEt Student by Id
 @GetMapping("/{studentId}")
public Student getById(@PathVariable Long studentId) {
	Student byId=studentService.getById(studentId);
	return byId;
	
}
 //get all data
 
 @GetMapping("/getAll")
 public List<Student>getAllData(){
	 List<Student>allstudent=studentService.getAllStudent();
	 return allstudent;
 }
 
 //UPDATE STUDENT
 @PutMapping("/update/{studentId}")
 public Student updateStudent(@PathVariable Long studentId,@Valid @RequestBody Student student) {
	 Student updateStudent=studentService.updateStudent(studentId, student);
	 return updateStudent;
 }
 
// DELETE STUDENT;
 
public String deleteStudent(@PathVariable Long studentId) {
	String deleteStudent=studentService.deleteStudent(studentId);
	return deleteStudent;
}
 
}
