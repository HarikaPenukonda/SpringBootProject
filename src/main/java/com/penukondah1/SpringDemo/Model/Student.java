package com.penukondah1.SpringDemo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity /*specifies that the class is an entity and is mapped to a database table*/
public class Student {
	
	@Id /*marks a field in a model class as the Primary key*/
	private String id;
	private String name;
	private String dept;
	
	/*A no-arg constructor, so that the object is easier to initialize*/
	public Student() {
	
	}
	
	/* A parameterized contructor which takes the arguments and intializes the object */
	public Student(String id, String name, String dept) {
		super();
		this.id = id;
		this.name = name;
		this.dept = dept;
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

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
	
	
	

}
