package com.penukondah1.SpringDemo.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.penukondah1.SpringDemo.Model.Course;

public interface CourseRepository extends CrudRepository<Course,String> {
	
	//a method which takes in a studentID and returns a list of courses
	
	//public Optional<Course> findByName(String sname);
	/*a method which gets all the courses based on the name */
	
	public List<Course> findByStudentId(String studentId);
}
