package com.penukondah1.SpringDemo.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.penukondah1.SpringDemo.Model.Student;
import com.penukondah1.SpringDemo.Repository.StudentRepository;

//This service creates a new instance and registers it
@Service
public class StudentService {
	
	@Autowired /*When spring creates an instance of student service 
	it's gonna inject an instance of the student repository */
	private StudentRepository studentRepository;
	
	
	public List<Student> getAllStudents(){
		List<Student> students = new ArrayList<>(); //creating a new student list
		studentRepository.findAll() //iterating over the result of the findAll from the student repository which is basically an iterable of all the students in the DB
		.forEach(students::add); //for each of them we are populating the student list with that element //lambda expression
		return students;
	}
	
	public Student getStudent(String id)
	{
		return studentRepository.findById(id);
	}
	
	public void addStudent(Student student)
	{
		studentRepository.save(student);
	}

	public void updateStudent(Student student, String id) 
	{
		studentRepository.save(student);
	}

	public void deleteStudent(String id) 
	{
		studentRepository.deleteById(id);
		
	}


}
