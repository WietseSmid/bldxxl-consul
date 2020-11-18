package com.capgemini.bldxxl.maindns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainDnsApplication {

	public static void main(String[] args) {
		java.security.Security.setProperty("networkaddress.cache.ttl" , "0");
		SpringApplication.run(MainDnsApplication.class, args);
	}

}
