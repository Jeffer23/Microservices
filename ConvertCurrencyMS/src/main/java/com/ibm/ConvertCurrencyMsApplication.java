package com.ibm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
@EnableCircuitBreaker
public class ConvertCurrencyMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConvertCurrencyMsApplication.class, args);
	}

	@Bean
	public Sampler defaultSampler() {
	    return Sampler.ALWAYS_SAMPLE;
	}
}
