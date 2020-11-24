package com.ibm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class LoginMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginMsApplication.class, args);
	}

}
