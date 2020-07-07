package com.penukondah1.SpringDemo.Repository;

import org.springframework.data.repository.CrudRepository;

import com.penukondah1.SpringDemo.Model.Student;

public interface StudentRepository extends CrudRepository <Student, String>{
	/*CrudRepository is a Spring Data Interface for generic CRUD
	 * operations on a repository of a specific type. It provides
	 * several methods out-of-the-box for interacting with DB
	 * Generic type <Entityclass, Id type> */
	
	

}
