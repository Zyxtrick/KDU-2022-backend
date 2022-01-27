package com.rishavkdu.springAnnotations.demo;

import com.rishavkdu.springAnnotations.demo.models.User;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class Application {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(UserUtilityConfig.class);
		context.getBean(UserUtility.class).removeUser();

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		User user = new User();
		user.setName("Rishav");
		user.setDob("2000-13-11");
		System.out.println(user);


		validator.validate(user)
				.stream()
				.forEach(violation -> System.out.println(violation.getMessage()));
	}

}
