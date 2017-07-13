package com.itlab2017;

import lombok.extern.log4j.Log4j;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@ComponentScan
//@EnableAutoConfiguration
@SpringBootApplication
@EnableScheduling
@Log4j
public class EcoserverApplication {

	static boolean isMqttServerEnabled = true;
	static boolean isSpringEnabled = false;

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(EcoserverApplication.class);
		app.setWebEnvironment(false);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}
}

