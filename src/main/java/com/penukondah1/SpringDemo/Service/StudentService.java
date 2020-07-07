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
	
	/* Using Arrays.asList method to create this list in line and calling the constructor on the student class
	 * to create new student objects*/
	private List<Student> students = new ArrayList<>(Arrays.asList(
			new Student("101","Archie","ECE"),
			new Student("102","Betty","CSE"),
			new Student("103","Cheryl","EEE"),
			new Student("104","Juniper","MECH"),
			new Student("105","Dagwood","CE")
			));
	
	public List<Student> getAllStudents(){
		List<Student> students = new ArrayList<>(); //creating a new student list
		studentRepository.findAll() //iterating over the result of the findAll from the student repository which is basically an iterable of all the students in the DB
		.forEach(students::add); //for each of them we are populating the student list with that element //lambda expression
		return students;
	}
	
	public Optional<Student> getStudent(String id)
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
