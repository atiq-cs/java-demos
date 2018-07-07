# Hello World MVC Application with Database
Spring Demos: java, mvc, mysql database, jdbc connection

Starting with the [previous article][1] we move forward.

## MySQL Install and Setup Database
Install MySQL, add to path, and fire it up from powershell,

    $ $Env:Path += 'C:\Program Files\MySQL\MySQL Server 8.0\bin;'
    $ & mysql -p --user=atiq mvc-example
    
[mysql 8.0 ref][2] provides detailed info on mysql command.

We create mysql user,

    create user 'springuser'@'localhost' identified by 'springpass';

In case we want to change password,
    
    SET PASSWORD FOR 'springuser'@'localhost' = 'springpass';

Let's give the user permission for the database to perform all kinds operations i.e, read, write,
    
    grant all on mvc-example.* to 'springuser'@'localhost';

[Documentation - Accessing data with MySQL][3] helps us learn how to set up and manage user accounts on MySQL and how to configure Spring Boot to connect to it at runtime. It provides [source in github][4] as well.

## Creating DIR Structure, Build and Run
We create directory structure,

    $ mkdir -p p2-mvc-db/src/main/java/hello
    $ cd p2-mvc-db

We create required source and build files and paste contents from [the link][2] referred above,

    $ New-Item build.gradle
    $ New-Item src/main/java/hello/User.java
    $ New-Item src/main/java/hello/Application.java
    $ New-Item src/main/java/hello/MainController.java
    $ New-Item src/main/java/hello/UserRepository.java

If it's too hard to follow or paste, we can copy those over from [github dir link][5].

Please note that naming for controller source file and class/method names inside should be correct. Here's helpful reference on Spring @GetMapping and @PostMapping: [controller-getmapping-postmapping][10]. A good article on controllers is: [pivotal - Must-Know Spring Boot Annotations: Controllers][11]
    
We build,

    $ gradle build

    BUILD SUCCESSFUL in 9s
    3 actionable tasks: 3 executed
    
Then we run it,

    $ java -jar build\libs\gs-spring-boot-0.1.0.jar

If we get an error like this,

    [main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown initiated...
    [main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown completed.
    [main] o.apache.catalina.core.StandardService   : Stopping service [Tomcat]
    [main] ConditionEvaluationReportLoggingListener :

    Error starting ApplicationContext. To display the conditions report re-run your application with 'debug' enabled.
    2018-07-06 17:50:24.016 ERROR 21912 --- [main] o.s.boot.SpringApplication               : Application run failed

    org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'entityManagerFactory' defined in class path resource [org/springframework/boot/autoconfigure/orm/jpa/HibernateJpaConfiguration.class]: Invocation of init method failed; nested exception is java.lang.NoClassDefFoundError: javax/xml/bind/JAXBException
    
Here's related stackoverflow post: [How to resolve java.lang.NoClassDefFoundError: javax/xml/bind/JAXBException in Java 9][8]

This means we need to add xml binds,

    $ java --add-modules java.xml.bind -jar build\libs\hello-mysql-0.1.0.jar

We navigate to demo URLs using links below,

 - [Add a record][6] with name John and email: john@coolsite.com
 - [View records][7]    

If you are using jetbrains [idea- Get started with Spring Boot][9] is related. 

  [1]: https://github.com/atiq-cs/java-spring-demos/blob/master/p1-mvc-hello/README.md
  [2]: https://dev.mysql.com/doc/refman/8.0/en/mysql.html
  [3]: https://spring.io/guides/gs/accessing-data-mysql/
  [4]: https://github.com/spring-guides/gs-accessing-data-mysql
  [5]: https://github.com/spring-guides/gs-accessing-data-mysql/tree/master/complete/src/main/java/hello
  [6]: http://localhost:8080/demo/add?name=John&email=john@coolsite.com
  [7]: http://localhost:8080/demo/all
  [8]: https://stackoverflow.com/q/43574426
  [9]: https://www.jetbrains.com/help/idea/spring-boot.html#d729768e2
  [10]: https://howtodoinjava.com/spring5/webmvc/controller-getmapping-postmapping
  [11]: http://engineering.pivotal.io/post/must-know-spring-boot-annotations-controllers/
