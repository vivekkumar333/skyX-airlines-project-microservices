package com.skyx.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableEurekaClient
public class SkyXAirlinesUserServiceApplication implements CommandLineRunner{
	public static void main(String[] args) {
		SpringApplication.run(SkyXAirlinesUserServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
	public void testUserSaveApi() {
		
	}

}
