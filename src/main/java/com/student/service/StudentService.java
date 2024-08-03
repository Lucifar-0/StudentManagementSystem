package com.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.SchedulingAwareRunnable;
import org.springframework.stereotype.Service;

import com.student.entity.Student;
import com.student.exception.CustomException.StudentNotExists;
import com.student.repository.studentResository;

@Service
public class StudentService {
	@Autowired
	private studentResository repository;

	public Student createData(Student student) {
		return repository.save(student);
	}
	
	// Get data
	public Student getById(Long studentId){
		
		Student byId=repository.findById(studentId)
				
				.orElseThrow(()->new StudentNotExists("Student Not Found with"+studentId));
		return byId;
	}
	
	// Get all student
	
	public List<Student>getAllStudent(){
		List<Student>all=repository.findAll();
		return all;	
	}
	//UPDATE CODE
	public Student updateStudent(Long studentId, Student student) {
		Student byId=repository.findById(studentId).get();
		byId.setFName(student.getFName());
		byId.setLName(student.getLName());
		byId.setAddress(student.getAddress());
		byId.setAge(student.getAge());
		Student save=repository.save(byId);
		return save;
	}
	// Delete Student;
	public String deleteStudent(Long studentId) {
		Student byId= repository.findById(studentId).get();
		repository.delete(byId);
		return "Data successfully deleted....";
	}
}
