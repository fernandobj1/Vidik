package com.fbj.checklist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.fbj.nefroCheck"})
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class})
public class nefroCheck {
	public static void main(String[] args) {
		SpringApplication.run(nefroCheck.class, args);
	}

}
