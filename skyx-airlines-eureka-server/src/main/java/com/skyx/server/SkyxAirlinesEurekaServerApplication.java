package com.skyx.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SkyxAirlinesEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SkyxAirlinesEurekaServerApplication.class, args);
	}

}
