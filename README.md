README: 
   this file is to explain the functions the program has and display the project structure 
   1. the project is about getting real time weather with given cities showing online
   2. the city can be added or deleted through modifying property file in springboot classpath
   3. the project is made by jdk8 and springboot technology currently deploying into the cloud, the address is        http://47.94.244.20:8080/WeatherChangeDemo/login
   4. the project structure is described as following:    
├─.mvn
│  └─wrapper
│          maven-wrapper.jar
│          maven-wrapper.properties
│          
├─.settings
│      org.eclipse.core.resources.prefs
│      org.eclipse.jdt.core.prefs
│      org.eclipse.m2e.core.prefs
│      
├─src
│  ├─main
│  │  ├─java
│  │  │  └─com
│  │  │      │  DemoApplication.java
│  │  │      │  
│  │  │      ├─common
│  │  │      │      ConstantUtils.java
│  │  │      │      HttpClientUtils.java
│  │  │      │      
│  │  │      ├─controller
│  │  │      │      LoginController.java
│  │  │      │      
│  │  │      └─model
│  │  │              Basic.java
│  │  │              HeWeather6.java
│  │  │              JsonRootBean.java
│  │  │              Now.java
│  │  │              Update.java
│  │  │              Weather.java
│  │  │              
│  │  ├─resources
│  │  │      application.properties
│  │  │      
│  │  └─webapp
│  │      ├─resources
│  │      │  └─js
│  │      │          jquery-1.8.3.min.js
│  │      │          
│  │      └─WEB-INF
│  │          └─jsp
│  │                  testWeather.jsp
│  │                  
│  └─test
│      └─java
│          └─com
│                  WeatherCaseTest.java
│                  
└─target
    │  WeatherChangeDemo.war
    │  WeatherChangeDemo.war.original
    │  
    ├─classes
    │  │  application.properties
    │  │  
    │  └─com
    │      │  DemoApplication$1.class
    │      │  DemoApplication.class
    │      │  
    │      ├─common
    │      │      ConstantUtils.class
    │      │      HttpClientUtils$1.class
    │      │      HttpClientUtils.class
    │      │      
    │      ├─controller
    │      │      LoginController.class
    │      │      
    │      └─model
    │              Basic.class
    │              HeWeather6.class
    │              JsonRootBean.class
    │              Now.class
    │              Update.class
    │              Weather.class
    │              
    ├─generated-sources
    │  └─annotations
    ├─generated-test-sources
    │  └─test-annotations
    ├─m2e-wtp
    │  └─web-resources
    │      └─META-INF
    │          │  MANIFEST.MF
    │          │  
    │          └─maven
    │              └─com
    │                  └─WeatherChangeDemo
    │                          pom.properties
    │                          pom.xml
    │                          
    ├─maven-archiver
    │      pom.properties
    │      
    ├─maven-status
    │  └─maven-compiler-plugin
    │      ├─compile
    │      │  └─default-compile
    │      │          createdFiles.lst
    │      │          inputFiles.lst
    │      │          
    │      └─testCompile
    │          └─default-testCompile
    │                  createdFiles.lst
    │                  inputFiles.lst
    │                  
    ├─surefire-reports
    │      com.WeatherCaseTest.txt
    │      TEST-com.WeatherCaseTest.xml
    │      
    ├─test-classes
    │  └─com
    │          WeatherCaseTest.class
    │          
    └─WeatherChangeDemo
        ├─META-INF
        ├─resources
        │  └─js
        │          jquery-1.8.3.min.js
        │          
        └─WEB-INF
            ├─classes
            │  │  application.properties
            │  │  
            │  └─com
            │      │  DemoApplication$1.class
            │      │  DemoApplication.class
            │      │  
            │      ├─common
            │      │      ConstantUtils.class
            │      │      HttpClientUtils$1.class
            │      │      HttpClientUtils.class
            │      │      
            │      ├─controller
            │      │      LoginController.class
            │      │      
            │      └─model
            │              Basic.class
            │              HeWeather6.class
            │              JsonRootBean.class
            │              Now.class
            │              Update.class
            │              Weather.class
            │              
            ├─jsp
            │      testWeather.jsp
            │      
            └─lib
                    classmate-1.3.4.jar
                    commons-codec-1.10.jar
                    fastjson-1.2.53.jar
                    hibernate-validator-5.3.5.Final.jar
                    httpclient-4.5.3.jar
                    httpcore-4.4.8.jar
                    jackson-annotations-2.8.0.jar
                    jackson-core-2.8.10.jar
                    jackson-databind-2.8.10.jar
                    jboss-logging-3.3.1.Final.jar
                    jcl-over-slf4j-1.7.25.jar
                    jstl-1.2.jar
                    jul-to-slf4j-1.7.25.jar
                    log4j-over-slf4j-1.7.25.jar
                    logback-classic-1.1.11.jar
                    logback-core-1.1.11.jar
                    slf4j-api-1.7.25.jar
                    snakeyaml-1.17.jar
                    spring-aop-4.3.12.RELEASE.jar
                    spring-beans-4.3.12.RELEASE.jar
                    spring-boot-1.5.8.RELEASE.jar
                    spring-boot-autoconfigure-1.5.8.RELEASE.jar
                    spring-boot-starter-1.5.8.RELEASE.jar
                    spring-boot-starter-logging-1.5.8.RELEASE.jar
                    spring-boot-starter-web-1.5.8.RELEASE.jar
                    spring-context-4.3.12.RELEASE.jar
                    spring-core-4.3.12.RELEASE.jar
                    spring-expression-4.3.12.RELEASE.jar
                    spring-web-4.3.12.RELEASE.jar
                    spring-webmvc-4.3.12.RELEASE.jar
                    univocity-parsers-2.5.9.jar
                    validation-api-1.1.0.Final.jar
                    

    
    Author	caosong
    E-mail	caosong8281@163.com
