# SpringBootProject

### Apache Derby
Apache Derby is a Relational Database Management System which is fully based on (written/implemented in) Java programming language. It is an open source database developed by Apache Software Foundation.

derby.jar - Database Engine and JDBC driver

The Database engine of Apache Derby is an embedded relational database engine which supports JDBC and SQL API’s.

This also acts as embedded Driver, using which you can communicate to Derby using Java applications.

Embedded mode - You can run derby in embedded mode using Java application (using embedded driver). If you deploy Derby in embedded mode, the database engine will run in the same JVM as the Java application. It starts and stops with the application. You can access the database only with this application.

Server mode - In the server mode, derby will be run in the JVM of an application server where you can send a request to the server to access it. Unlike in embedded mode, multiple applications (java) can send a request to the server and access the database.

