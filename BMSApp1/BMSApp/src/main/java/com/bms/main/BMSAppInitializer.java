package com.bms.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan("com.bms")
public class BMSAppInitializer 
{
  
	 public static void main(String[] args) {
		SpringApplication.run(BMSAppInitializer.class, args);
		
	}
}
	
