package com.itlab2017;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@ComponentScan
//@EnableAutoConfiguration
@SpringBootApplication
public class EcoserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcoserverApplication.class, args);
	}
}

