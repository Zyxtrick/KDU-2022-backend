package com.rishav.aopExample;

import com.rishav.aopExample.student.Student;
import com.rishav.aopExample.teacher.Teacher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		Student student = context.getBean(Student.class);
		Teacher teacher = context.getBean(Teacher.class);
		System.out.println("Average marks : " + student.getAverageMarks(10, 20, 40));
		teacher.displayMessage();
		teacher.displaySubjectTaught("Science");
	}
}