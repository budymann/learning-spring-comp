package com.budymann.example.aspectorientedprogramming;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

import java.lang.annotation.Target;

@SpringBootApplication
public class AspectOrientedProgrammingApplication {
	public static void main(String[] args) {
		SpringApplication.run(AspectOrientedProgrammingApplication.class, args);
	}

}
