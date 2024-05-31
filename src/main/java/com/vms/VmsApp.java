package com.vms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class VmsApp extends SpringBootServletInitializer {
	public static void main(String[] args) {
		System.out.println("VMS App");
		SpringApplication.run(VmsApp.class, args);
	}
}
