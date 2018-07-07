# Hello World MVC Application
Spring Demos: java, mvc

## Installation Instruction
First we install JDK for java, gradle and for build system. Since I am starting from beginning it's also an avenue to explore the new build gradle. I use [chocolatey][5] to install JDK. I download gradle from [binary-only 4.8.1][4] link can be found at [gradle releases][3] and extract the gradle archive. I add this gradle path to System. That works great.

[spring boot reference - boot-documentation-getting-help][1] provides helper links for starters.
[Spring Docs - Building an Application with Spring Boot][2] is primary reference for this demo to build with gradle.

I add java, spring, gradle in path, (using Powershell),

    $ $Env:Path += 'D:\PFiles_x64\gradle\bin;'
    $ $Env:Path += 'D:\PFiles_x64\choco\jdk10\bin;'
    $ $Env:Path += 'D:\PFiles_x64\spring\bin;

Check spring version,

    $ spring --version
    Spring CLI v2.0.3.RELEASE
    $ spring help run

## Creating DIR Structure, Build and Run
We create the dir structure,

    $ mkdir -p p1-mvc-hello/src/main/java/hello
    $ cd p1-mvc-hello

We create required source and build files and paste contents from [the link][2] referred above,

    $ New-Item build.gradle
    $ New-Item src/main/java/hello/HelloController.java
    $ New-Item src/main/java/hello/Application.java

We build,

    $ gradle build
    Starting a Gradle Daemon (subsequent builds will be faster)

    BUILD SUCCESSFUL in 22s
    2 actionable tasks: 2 executed
    
Then we run it,

    $ java -jar .\build\libs\gs-spring-boot-0.1.0.jar

      .   ____          _            __ _ _
     /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
    ( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
     \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
      '  |____| .__|_| |_|_| |_\__, | / / / /
     =========|_|==============|___/=/_/_/_/
     :: Spring Boot ::        (v2.0.3.RELEASE)    

    [main] hello.Application                        : Starting Application on Atiq-Research with PID 21712 [           main] hello.Application                        : No active profile set, falling back to default profiles: default
    [main] ConfigServletWebServerApplicationContext : Refreshing org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext@5af3afd9: startup date [Fri Jul 06 16:00:41 PDT 2018]; root of context hierarchy
    WARNING: An illegal reflective access operation has occurred
    WARNING: Illegal reflective access by org.springframework.cglib.core.ReflectUtils$1 (jar:file:/D:/Code/java/spring/p1-hello-world/build/libs/gs-spring-boot-0.1.0.jar!/BOOT-INF/lib/spring-core-5.0.7.RELEASE.jar!/) to method java.lang.ClassLoader.defineClass(java.lang.String,byte[],int,int,java.security.ProtectionDomain)
    WARNING: Please consider reporting this to the maintainers of org.springframework.cglib.core.ReflectUtils$1
    WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations
    WARNING: All illegal access operations will be denied in a future release
    [main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
    [main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
    [main] org.apache.catalina.core.StandardEngine  : Starting Servlet Engine: Apache Tomcat/8.5.31
    
To debug or see more of info what's happening when we are running the application we can add `-debug` with `java -jar jar_file_path` command.

Then, we navigate to [localhost URL for tomcat][9] which gives us this,

![Spring Boot MVC Demo][10]

## gradle reference
[gradle Command-Line Interface][8] can be useful in seeing what we can do with `gradle` command.

[Introduction to Dependency Management - pom.xml][6] provides guidance on dep managment using pom.xml. [gradle's doc][7] provides more.
    
  [1]: https://docs.spring.io/spring-boot/docs/2.0.3.RELEASE/reference/htmlsingle/#boot-documentation-getting-help
  [2]: https://spring.io/guides/gs/spring-boot/
  [3]: https://gradle.org/releases/
  [4]: https://gradle.org/next-steps/?version=4.8.1&format=bin
  [5]: https://chocolatey.org/
  [6]: https://github.com/spring-guides/gs-accessing-data-mysql/blob/master/complete/pom.xml
  [7]: https://docs.gradle.org/current/userguide/introduction_dependency_management.html
  [8]: https://docs.gradle.org/current/userguide/command_line_interface.html
  [9]: http://localhost:8080
  [10]: https://github.com/atiq-cs/atiqcs-wp-com/raw/master/images/2018/07/04_spring-boot-demo1.png
