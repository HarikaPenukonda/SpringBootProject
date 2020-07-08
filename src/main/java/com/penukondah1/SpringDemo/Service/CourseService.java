package com.penukondah1.SpringDemo.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.penukondah1.SpringDemo.Model.Course;
import com.penukondah1.SpringDemo.Repository.CourseRepository;

@Service
public class CourseService {
	
	@Autowired 
	private CourseRepository courseRepository;
	
	
	public List<Course> getAllCourses(String studentId){
		List<Course> courses = new ArrayList<>(); //creating a new course list
		courseRepository.findByStudentId(studentId)
		.forEach(courses::add); //for each of them we are populating the course list with that element //lambda expression
		return courses;
	}
	
	public Course getCourse(String id)
	{
		//courseRepository.findByName("");
		Optional<Course> optionalEntity = courseRepository.findById(id);
		Course course = optionalEntity.get();
		return course;
	}
	public void addCourse(Course course)
	{
		courseRepository.save(course);
	}

	public void updateCourse(Course course) 
	{
		courseRepository.save(course);
	}

	public void deleteCourse(String id) 
	{
		courseRepository.deleteById(id);
		
	}

}
