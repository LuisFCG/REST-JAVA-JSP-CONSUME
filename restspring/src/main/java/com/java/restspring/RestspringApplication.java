package com.java.restspring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RestspringApplication {
	
	private static final Logger log = LoggerFactory.getLogger(RestspringApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RestspringApplication.class, args);
	
		
	}

}
