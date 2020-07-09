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

2. **Spring Boot Starter Security** is used for spring security

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

	<packaging>war</packaging>
 
 deploy the WAR files under the webapps directory
 
### 3.Spring Boot - Build Systems
 
#### Dependency Management

Spring Boot team provides a list of dependencies to support the Spring Boot version for its every release. We do not need to provide a version for dependencies in the build configuration file. Spring Boot automatically configures the dependencies version based
on the release

#### Maven Dependency

For maven configuration, we should inherit the SPring Boot Starter parent project to manage the Spring Boot dependencies.

	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>1.5.8.RELEASE</version>
	</parent>

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

In Spring, the objects that form the backbone of our application and that are managed by the Spring IoC container are called beans. A bean is an object instantiated, assembled and otherwise managed by a Spring IoC container.

#### Spring Boot - Runners

**Application Runner**

Application Runner is an interface used to execute the code after the Spring Boot application started. 

**Command Line Runner**

Command Line Runner is an interface. It is used to execute the code after the Spring Boot application started.


#### Spring Boot - Application Properties

**Command Line Properties**

Spring Boot application converts the command line properties into Spring Boot Environment properties.Command line properties take precedence over the other property sources.By default, Spring Boot uses the 8080 port number to start the Tomcat.

	C:\demo\target>java -jar demo-0.0.1-SNAPSHOT.jat --server.port=9090

**Properties File**

Properties files are used to keep 'N' number of properties in a single file to run the application in a different environment.In Spring Boot, properties are kept in the **application.properties** file
	
	server.port=9090
	spring.application.name=demoservice

**YAML file**
Spring Boot supports YAML based properties configurations to run the application. Instead of **application.properties**, we can use **application.yml** file. This YAML file also should be kept inside the classpath.

	spring:
		application
		name: demoservice
	server:
		port:9090
		
**Externalized Properties**

Instead of keeping the properties file under classpath, we can keep the properties in different location or path. While running the JAR file, we can specify the properties file path.

	>java -jar -Dspring.config.location=C:\application.properties demo-0.0.1-SNAPSHOT.jar
	
**@Value Annotation**

The @Value is used to read the environment or application property value in Java Code.

	@Value("${spring.application.name:demoservice}")

**Spring Boot Active Profile**

Spring Boot supports different properties based on the Spring active profile. We can keep two seperate file for development and production to run the Spring Boot application.

**application-dev.properties**
	
	server.port=9090
	spring.application.name=demoservice


**application-prod.properties**
	
	server.port=4431
	spring.application.name=demoservice

#### Spring Boot - Logging

Spring Boot uses Apache COmmons logging for all internal logging. Spring Boot's default configurations provides a support for the use of Java Util Logging, Log4j2, and Logback. Using these, we can configure the console logging as well as file logging.

Spring Boot Starters, Logback will provide a good support for logging.

1. Date and time that gives the date and time of the log.
2. Log level shows INFO, ERROR or WARN
3. Process ID
4. The --- is a separator
5. Thread name is enclosed with in square brackets []
6. Logger Name that shows the Source class name
7. The log message

If we have to enable the debug level log
	
	java -jar demo.jar --debug

application.properties

	debug=true 
	
**File Log Output**

By default, all logs will print on the console window and not in the files. If we want to print the logs in a file, we need to set the property **logging.file** or **logging.path** in the application.properties file.

**Log levels**

Spring Boot supports all logger levels such as “TRACE”, “DEBUG”, “INFO”, “WARN”,
“ERROR”, “FATAL”, “OFF”.we can define Root logger in the application.properties file as

	logging.level.root=WARn

**Note:** Logback does not support “FATAL” level log. It is mapped to the “ERROR” level log.

**Configure Logback**

Logback supports XML based configuration to handle Spring Boot Log configurations. Logging configuration details are configured in **logback.xml** file.

	@SpringBootApplication{
		private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class):
		
		public static void (String[] args){
		logger.info("this is a info message");
		logger.warn("this is a warn message");
		logger.error("this is a error message");
		SpringApplication.run(DemoApplication.class,args);
		}
	}

#### Spring Boot - Building RESTful web services

Spring Boot provides a very good support to building RESTful Web Services for enterprise applications.

**Note:** For building a RESTful Web Services, we need to add the Spring Boot Starter Web dependency into the build configuration file.

**Rest Controller**

The @RestController is used to define the RESTful web services. It serves JSON, XML and custom response.

**Request Mapping**

The @RequestMapping annotation is used to define the Request URI to access the REST endpoints. The default request method is GET.

**Request Body**

The @RequestBody is used to define the request body content type

**Path Variable**
The @PathVariable is used to define the custom or dynamic request URI. it is defined as curly braced{}
	 
	 public ResposeEntity<Object> updateProduct(@PathVariable("id") String id)
	 {}
	 
**Request Parameter**
The @RequestParam is used to read the request parameter from the the Request URL.By default, it is a required parameter.

	public ResponseEntiry<Object> getProduct(@RequestParam(value="name",required=false, defaultValue="honey") String name
	{
	}


**GET API**

The default HTTP request method is GET. This method does not require any Request Body. We can send request parameters and path variables to define the custom or dynamic URL.

**POST API**

The HTTP POST requst is used to create a resource. This method contains the Request Bosy. We cans send request parameters and path variables to define custom or dynamic URL.

**PUT API**

The HTTP PUT request is used to update the existing resource. This method contains a Request Body.

**DELETE API**

The HTTP Delete request is used to delete the existing resource. This method does not contain any request Bosy.

#### Spring Boot - Service Components

Service Components are the class file which contains @Service annotation. These class files are used to write business logic in a different layer, seperated from @RestController class file.
	
	public interface ProductService
	{}
	
The class that implements the the interface with @Service annotation
	
	@Service
	public class ProdServiceIml implements ProductService
	{}

#### Spring Boot - Thymeleaf

THymeleaf is Java-based library used to create a web application. It provides a good support for serving a XHTML/HTML5 in web applications


#### Spring Boot - Enabling Swagger 2

Swagger2 is an open source project used to generate the REST API documents for RESTful web services.It provides a user interface to access our RESTful web services via the web browser.

	<dependency>
	<groupId>io.springfox</groupId>
	<artifactId>springfox-swagger2</artifactId>
 	<version>2.7.0</version>
	</dependency>
	<dependency>
 	<groupId>io.springfox</groupId>		 
 	<artifactId>springfox-swagger-ui</artifactId>
	<version>2.7.0</version>
	</dependency>
	

**@EnableSwagger2** annotation is used to enable the Swagger2 in our Spring boot application.Add in main Spring boot application.

	@SpringBootApplication
	@EnableSwagger2
		public class SwaggerDemoApplication {
			public static void main(String[] args) {
			SpringApplication.run(SwaggerDemoApplication.class, args);
				}
			}
	

Create Docket Bean to configure Swagger2 for Spring Boot Application.

	@Bean
	public Docket productApi() {
			return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.tutorialspoint.swaggerdemo"
	)).build();
	}
	


#### Spring Boot - Creating Docker Image

Docker is a container management service that eases building and deployment. The whole idea of Docker is for developers to easily develop applications, ship them into containers which can be developed anywhere.

First, create a file with name **Dockerfile** under the directories src/main/docker with the contents shown.Note that this file is important to create a Docker image.

	FROM java:8
	VOLUME /tmp
	ADD dockerapp-0.0.1-SNAPSHOT.jar app.jar
	RUN bash -c 'touch/app.jar'
	ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
	
	
Maven

	<properties>
		<docker.image.prefix>spring-boot-tutorialspoint</docker.image.prefix>
	</properties>
	
	<build>
		<plugins>
				<plugin>
					<groupId>com.spotify</groupId>
					<artifactId>docker-maven-plugin</artifactId>
					<version>1.0.0</version>
					<configuration>
					<imageName>${docker.image.prefix}/${project.artifactId}</imageName>
					<dockerDirectory>src/main/docker</dockerDirectory>
					<resources>
						<resource>
							<directory>${project.build.directory}</directory>
							<include>${project.build.finalName}.jar</include>
						</resource>
					</resources>
					</configuration>
				</plugin>
		<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
				</plugin>
		</plugins>
	</build>
	
	

#### Spring Boot - Flyway Database

Flyway is a version control application to evolve our DB schema easiy and reliably across all our instances.

Many software projects use relational databases. This requires handling of database migrations, called as Schema migrations.

Dependencies:
1. Spring Boot Starter Web
2. Flyway
3. MySQL
4. JDBC

Application Properties :
	 
	 spring.application.name=flywayapp
	spring.datasource.driverClassName=com.mysql.jdbc.Driver
	spring.datasource.url=jdbc:mysql://localhost:3306/USERSERVICE autoreconnect=true
	spring.datasource.username=root
	spring.datasource.password=root
	spring.datasource.testOnBorrow=true
		spring.datasource.testWhileIdle=true
	spring.datasource.timeBetweenEvictionRunsMillis=60000
	spring.datasource.minEvictableIdleTimeMillis=30000
	spring.datasource.validationQuery=SELECT 1
	spring.datasource.max-active=15
	spring.datasource.max-idle=10
	spring.datasource.max-wait=8000
	flyway.url=jdbc:mysql://localhost:3306/mysql
	flyway.schemas=USERSERVICE
	flyway.user=root
	flyway.password=root

Now, create a SQL file under the **src/main/resources/db/migration** directory. Name the SQL file as "V1_Initial.sql"

	create table users (id int auto_increment primary key,userid varchar(45));
	insert into users (id,userid) values (1,'abc.com'');


#### Spring Boot - Sending Email

By using Spring Boot RESTful web services, we can send email with Gmail Transport Layer Security.
	
	<dependency>
 	<groupId>org.springframework.boot</groupId>
 	<artifactId>spring-boot-starter-mail</artifactId>
	</dependency>

#### Spring Boot - Hystrix

A typical distributed system consists of many services collaborating together.

These services are prone to failure or delayed responses. If a service fails it may impact on other services affecting performance and possibly making other parts of application inaccessible or in the worst case bring down the whole application.

there are solutions available that help make applications resilient and fault tolerant – one such framework is Hystrix.

Hystrix is a library from Netflix, it helps to control the interaction between services by providing fault tolerance and latency tolerance. It improves overall resilience of the system by isolating the failing services and stopping the cascading effect of failures.

	<dependency>
	<groupId>org.springframework.cloud</groupId>
 	<artifactId>spring-cloud-starter-hystrix</artifactId>
	</dependency>
	
The **@EnableHystrix** annotation is used to enable the Hystrix functionalities into your
Spring Boot application.

#### Spring Boot - Web Socket

To build an interactive web application in Spring Boot with Web Socket, we need to add following dependendcies

1. spring-boot-starter-websocket
2. webjars-locator
3. sockjs-client
4. stomp-websocket
5. bootstrap
6. jquery

A message handling controller can be create with STOMP messaging. STOMP messages can be routed to @Controller class file.

The **@EnableWebSocketMessageBroker** annotation is used to configure the Web socket message broker to create STOMP endpoints.


#### Spring Boot - Spring for Apache Kafka

In Big Data, an enormous volume of data is used. Regarding data, we have two main challenges. The first challenge is how to collect large volume of data and the second challenge is to analyze the collected data. To overcome those challenges we must need a messaging system.

A messaging system is responsible for transferring data from one application to another, so the applications can focus on data, but not worry about how to share it.

Apache Kafka is an open source project used to publish and subscribe the messages based on the fault-tolerant messaging system. It is fast, scalable and distributed by design.

It is a distributed publish-subscribe messaging system and a robust queue that can handle a high volume of data and enables you to pass messages from one end-point to another.It is suitable for both offline and online message consumption. 

	<dependency>
 	<groupId>org.springframework.kafka</groupId>
 	<artifactId>spring-kafka</artifactId>
 	<version>2.1.0.RELEASE</version>
	</dependency>
	
#### Spring Boot - Twilio

Twilio is a third party application used to send SMS and make voice calls from our application. It allows us to send the SMS and make voice calls programatically.
	
	<dependency>
  	<groupId>com.twilio.sdk</groupId>
 	<artifactId>twilio</artifactId>
 	<version>7.16.1</version>
	</dependency>

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

1. S save(S entity) - we can pass multiple objects to save them in a batch
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