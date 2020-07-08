# SpringBootProject

Spring boot is an open source Java-based framework used to create a micro-service.

#### Micro Service?
It is an architechture that allows the developers to develop and deploy services independently. Each service running has its own processes and this achieves the lightweight model to support business applications.

**Advantages**
1. Easy deployment
2. Simple scalability
3. Compatible with containers
4. Minimum configuration
5. Lesser production time

#### What is Spring Boot?
It provides a good platform for java-developers to develop a stand-alone spring application that we can just run.

**Advantages**
1. Easy to uderstand and develop spring applications
2. Increases productivity
3. Reduces the development time

**Goals**
1. avoids complex XML configuration
2. develop a production ready spring application in a easier way
3. reduces the development time and run the application independently

**why Spring Boot?**
1. provides a flexible way to configure Java Beans, XML configurations and Database transactions.
2. Provides a powerful batch processing and manages REST endpoints.
3. everything is auto configured, no manual changes are needed.
4. offers annotation based spring application
5. Eases dependedency management
6. Includes Embedded servlet container

**How does it work?**
Spring boot automatically configures our application based on the dependencies we have added to the project by using **@EnableAutoConfiguration**.

The entry point of the spring boot application is the class cotains **@SpringBootApplication** and the main method.

Spring Boot automatically scans all the components included in the project by using **@ComponentScan**

#### dependencies
1. **Spring Boot Starter Actuator** is used to monitor and manage our application

2.**Apring Boot Starter Security** is used for spring security

3. **Spring Boot Starter Thyme Leaf dependency** is used to create a web application.

4. **Spring Boot Starter Test dependency** is used for writing test cases.

#### Auto Configuration

Spring Boot Auto Configuration automatically configures our spring application based on our JAR dependencies we add in our project. For this purpose, we need to add **@EnableAutoConfiguration** or **@SpringBootApplication** to our main class.Then, our spring boot application configured.

#### Spring Boot Application

The entry point of the Spring Boot Application is the class contains **@SpringBootApplication** annotation. This class should have the main method to run the Spring Boot application. **@SpringBootApplication** annotation includes **AutoConfiguration**, **ComponentScan**, and **SpringBoot Configuration**.

#### Component Scan

Spring Boot application scans all the beans and package declarations when the application intializes.We need to add **@ComponentScan** in our class file to scan our compnents in our project.

### 2.Spring Boot - Bootstrapping

#### Spring Initializer

One of the ways to Bootstrapping a Spring Boot application is by using Spring Initializer. 

By using Spring boot application we can create a war file to deploy into web server.

#### Spring Boot Servlet Initializer
The traditional way of deployment is making the Spring Boot Application **@SpringBootApplication** class extend the **SpringBootServletInitialzer** class.
Spring Boot Servlet Initializer class file allows you to configure the application when it is launched by using Servlet Container.

**Update packaging JAR into WAR**

For Maven, add the packaging as WAR in pom.xml as

 **<packaging>war</packaging>**
 
 deploy the WAR files under the webapps directory
 
### 3.Spring Boot - Build Systems
 
#### Dependency Management

Spring Boot team provides a list of dependencies to support the Spring Boot version for its every release. We do not need to provide a version for dependencies in the build configuration file. Spring Boot automatically configures the dependencies version based
on the release

#### Maven Dependency

For maven configuration, we should inherit the SPring Boot Starter parent project to manage the Spring Boot dependencies.

**<parent>**

	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-parent</artifactId>
	<version>1.5.8.RELEASE</version>
	
**</parent>**

we should specify the version number for Spring Boot Parent Starter dependency. Then for other starter dependencies, we do not need to specify the Spring Boot version number.


<dependencies>
	
	<dependency>
		 <groupId>org.springframework.boot</groupId>
		 <artifactId>spring-boot-starter-web</artifactId> 
	</dependency>
	
</dependencies>

Spring Boot will cause issues such as malfunctioning of Auto Configuration or Component Scan, when we use default package.

#### Spring Boot - Spring Beans and Dependency Injection

In Spring Boot, we can use Spring Framework to define our beans and their dependencies injection. The **@ComponentScan** is used to find beans and corresponding injected with **@Autowired** annotation




### Apache Derby
Apache Derby is a Relational Database Management System which is fully based on (written/implemented in) Java programming language. It is an open source database developed by Apache Software Foundation.

derby.jar - Database Engine and JDBC driver

The Database engine of Apache Derby is an embedded relational database engine which supports JDBC and SQL API’s.

This also acts as embedded Driver, using which you can communicate to Derby using Java applications.

Embedded mode - You can run derby in embedded mode using Java application (using embedded driver). If you deploy Derby in embedded mode, the database engine will run in the same JVM as the Java application. It starts and stops with the application. You can access the database only with this application.

Server mode - In the server mode, derby will be run in the JVM of an application server where you can send a request to the server to access it. Unlike in embedded mode, multiple applications (java) can send a request to the server and access the database.

The framework sees the embedded Derby database in the classpath and assumes that to be the database to connect to. No connection information necessary.

### Differences between CrudRepository, JPARepository and PagingAndSortingRepository

Every repository in Spring Data extends the generic Repository Interface.

1. CrudRepository provides CRUD functions.
2. PagingAndSortingRepository provides methods to do pagination and sort records.
3. JPARepository provides JPA related methods such as flushing the persistence context and delete records in a batch. 

CRUD functionality

1. <S extends T> S save(S entity) - we can pass multiple objects to save them in a batch
2. T findOne(ID primaryKey) - get a single entity based on passed primary key value
3. Iterable<T> findAll() - get an iterable of all available entities in database.
4. Long count() - return the count of total entities in a table
5. void delete(T entity) - delete an entity based on the passed object
6. boolean exists(ID primaryKey) - verify if an entity exists based on the passed primary key 

JpaRepository functionality
1. List<T> findAll() - get a List of all available enties in DB
2. List<T> findAll(Sort sort) - get a list of all available enties and sort them using the provided condition
3. List<T> save(Iterable<?extends T> entities) - save an iterable of entites. We can pass multiple objects to save them in a batch
4. void flush() - flush(commit) all pending task to the DB
5. T saveAndFlush (T entity) - save the entity and flush changes immediately
6. void deleteInBatch(Iterable<T>entities) - delete an Iterable of entities. Here, we can pass multitple objects to delete them in a batch.

### optional class
In Java 8,introduced Optional class in java.util package. This class is introduced to avoid NullPointerException that we frequently encounters if we do not perform null checks in our code. Using this class we can easily check whether a variable has null value or not and by doing this we can avoid the NullPointerException. 

The purpose of the class is to provide a type-level solution for representing optional values instead of null references.

### Definitions
1. @RestController - this asks spring MVC to look for web routes. It also indicates that every HTTP endpoint in the class will write its results directly into the HTTP response instead of using a view. it is basically @Controller plus @ResponseBody

2. @RequestMapping - maps the method to url

3. spring-boot-starter-web - A spring boot pkg that pulls all the dependencies needed for a Spring MVC app.

4. @EnableAutoConfiguration - Signals Spring boot to start making opinoinated decisions on adding various components to our app.

5. SpringApplication.run() - This method is Spring Boot's API to start up our app and create an application context. Wrapping it in static void main means that we can run this app anywhere there is a JVM installed.

6. @RequestParam - to extract query parameters from the request

#### Errors documentaation 
1. Schema 'SA' does not exist

**Solution** - This error appears in Derby only. It is because your Properties default is set to: spring.jpa.hibernate.ddl-auto=create-drop

We have to set it to **spring.jpa.hibernate.ddl-auto=update**