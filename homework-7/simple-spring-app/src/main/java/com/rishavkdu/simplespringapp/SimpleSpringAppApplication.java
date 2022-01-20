package com.rishavkdu.simplespringapp;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SimpleSpringAppApplication{

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

//		Operation obj = (Operation) context.getBean("product"); //new Product();
//		obj.getResult(9);
//
//		Operation obj2 = (Operation) context.getBean("add"); //new Product();
//		obj2.getResult(3);

		//Scope
//		Operation obj3 = (Operation) context.getBean("add-singleton"); //new Product();
//		obj3.setNum(7777);
//		Operation obj4 = (Operation) context.getBean("add-singleton"); //new Product();
//		System.out.println("With Scope Singleton");
//		obj3.getResult(7);
//		obj4.getResult(7);
//
//		Operation obj5 = (Operation) context.getBean("add-proto"); //new Product();
//		obj5.setNum(7777);
//		Operation obj6 = (Operation) context.getBean("add-proto"); //new Product();
//		System.out.println("With Scope Prototype");
//		obj5.getResult(7);
//		obj6.getResult(7);


		//Cyclic Dependancy
		CyclicDependancyA a = (CyclicDependancyA) context.getBean("cA");
		System.out.println(a.getB());

	}

}
