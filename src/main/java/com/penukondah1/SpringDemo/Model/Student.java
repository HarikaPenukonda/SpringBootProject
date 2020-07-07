package com.penukondah1.SpringDemo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity /*specifies that the class is an entity and is mapped to a database table
*/
public class Student {
	
	@Id /*marks a field in a model class as the Primary key*/
	private String sid;
	private String sname;
	private String dept;
	
	/*A no-arg constructor, so that the object is easier to initialize*/
	public Student() {
	
	}
	
	/* A parameterized contructor which takes the arguments and intializes the object */
	public Student(String sid, String sname, String dept) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.dept = dept;
	}
	
	
	
	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}

}
