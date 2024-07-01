package com.codingshuttle.abhisek.week1Introduction.IntroductionToSpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.graphql.ConditionalOnGraphQlSchema;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class IntroductionToSpringBootApplication implements CommandLineRunner {

	@Autowired
	@Qualifier("getApple")
	Apple apple1;

	@Autowired
	@Qualifier("apple")
	Apple apple2;

	@Autowired
	@Qualifier("apple")
	Apple apple3;

	@Autowired
	@Qualifier("getApple")
	Apple apple4;

	public static void main(String[] args) {
	    SpringApplication.run(IntroductionToSpringBootApplication.class, args);
//		String[] beanNames = context.getBeanDefinitionNames();
//		for (String beanName : beanNames) {
//			System.out.println("Bean name: " + beanName);
//		}

	}

	@Override
	public void run(String... args) throws Exception {
         apple1.eatApple();
		 apple2.eatApple();

		System.out.println(apple1.hashCode());
		System.out.println(apple2.hashCode());
		System.out.println(apple3.hashCode());
		System.out.println(apple4.hashCode());
	}
}
