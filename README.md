# SpringBootProject

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

#### Errors documentaation 
1. Schema 'SA' does not exist

**Solution** - This error appears in Derby only. It is because your Properties default is set to: spring.jpa.hibernate.ddl-auto=create-drop

We have to set it to **spring.jpa.hibernate.ddl-auto=update**