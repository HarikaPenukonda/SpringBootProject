package com.penukondah1.SpringDemo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.penukondah1.SpringDemo.Model.Student;
import com.penukondah1.SpringDemo.Service.StudentService;



@RestController
public class StudentController {
	
	//instance of studentservice - no need to create a new instance every time, Singleton needs the instance that spring created
	//private member variable 
	@Autowired //depencency to student service -- for depency injection 
	private StudentService studentService;
	
	@RequestMapping("/students")
	public List<Student> getAllStudents()
	{
		
		return studentService.getAllStudents();
	}	
		/* Spring MVC - when there is /student request it maps getAllStudents method , execute that method and returns 
		 * the object. The returned object is gonna get converted to JSON automatically and send back as HTTP response*/
		
		/*The generated JSON has key names corresponding to property names of the student class. The JSON values are 
		 * values of those properties*/
		
	@RequestMapping("/students/{id}") //{id} to inform spring that it is variable {token}
	public Student getStudent(@PathVariable String id) 
	/*@PathVariable to send the variable {id} as the argument te that respective method
	It maps {id} to String id of the method getStudent*/
	{
		return studentService.getStudent(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/students")
	/* Specify the method itself, in order to specify a value I used enumeration
	 * Which is called a request method and choose post. method=RequestMethod.POST 
	 * is custom property and value="/students is value property. Map this method to any request that 
	 * is a post on /students*/
	public void addStudent(@RequestBody Student student) 
	/* @RequestBody tells spring MVC that our request payload contain a 
	 * JSON representation of student instance and we are asking to take the request body
	 * and convert it into student instance pass it to addTopic when the URL is mapped
	 * */
	{
		/*Get the post body convert it into a student instance and add that 
		 * into a list in the student service */
		studentService.addStudent(student);
		
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/students/{id}")
	public void updateStudent(@RequestBody Student student, @PathVariable String id)
	{
		studentService.updateStudent(student,id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/students/{id}")
	public void deleteStudent(@PathVariable String id)
	{
		studentService.deleteStudent(id);
	}


}
