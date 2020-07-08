package com.penukondah1.SpringDemo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity /*specifies that the class is an entity and is mapped to a database table*/
public class Course {
	
	@Id /*marks a field in a model class as the Primary key*/
	private String id;
	private String name;
	private String description;
	//private String studentId;
	
	@ManyToOne //Many courses can be taken by one student, JpaAnnotation
	private Student student;
	
	public Course()
	{
		
	}
	
	public Course(String id, String name, String description, String studentId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.student = new Student(studentId, "", ""); /*construct a new student with id being sid and eempty string as name and dept*/
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	
	
	

	
	
	
	

}
