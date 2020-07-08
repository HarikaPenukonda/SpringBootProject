package com.penukondah1.SpringDemo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.penukondah1.SpringDemo.Model.Course;
import com.penukondah1.SpringDemo.Model.Student;
import com.penukondah1.SpringDemo.Service.CourseService;


@RestController
public class CourseController {
	
		@Autowired //depencency to student service -- for depency injection 
		private CourseService courseService;
		
		@RequestMapping("/students/{id}/courses")
		public List<Course> getAllCourses(@PathVariable String id)
		{
			
			return courseService.getAllCourses(id);
		}	
			
		@RequestMapping("/students/{studentId}/courses/{id}") //{id} to inform spring that it is variable {token}
		public Course getCourse(@PathVariable String id) 
		{
			return courseService.getCourse(id);
		}
		
		@RequestMapping(method=RequestMethod.POST, value="/students/{studentId}/courses")
		public void addCourse(@RequestBody Course course,@PathVariable String studentId) //give sid as method arguemnt with the help of PathVariable
		{
			course.setStudent(new Student(studentId, "", "")); 
			courseService.addCourse(course);
			/*whatever is sent as the request body for the course, I set the student on it, ignore the 
			student that comes with the request, set a new student and make sure studentid is sid based on the value 
			passed and can save the course. */ 
		}
		
		@RequestMapping(method=RequestMethod.PUT, value="/students/{studentId}/courses/{id}")
		public void updateCourse(@RequestBody Course course,@PathVariable String studentId, @PathVariable String id)
		{
			course.setStudent(new Student("studentId","",""));
			courseService.updateCourse(course);
		}
		
		@RequestMapping(method=RequestMethod.DELETE, value="/students/{studentId}/courses/{id}")
		public void deleteCourse(@PathVariable String id)
		{
			courseService.deleteCourse(id);
		}

}
