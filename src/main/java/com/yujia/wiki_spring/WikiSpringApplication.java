package com.yujia.wiki_spring;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class   WikiSpringApplication {
    private static final Logger log = LoggerFactory.getLogger( WikiSpringApplication.class );
    public static void main(String[] args) {
        //initialize
        SpringApplication app=new SpringApplication(WikiSpringApplication.class);
        Environment env = app.run(args).getEnvironment();
        log.info("Successfully !!!");
        log.info("Address: \t http://127.0.0.1:{}",env.getProperty("server.port"));
    }

}
