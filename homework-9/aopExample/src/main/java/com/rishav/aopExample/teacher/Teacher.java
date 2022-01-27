package com.rishav.aopExample.teacher;

import org.springframework.stereotype.Component;


@Component
public class Teacher {
    private String name;
    private int averageMarks;

    public void displayMessage(){
        System.out.println("This is the teacher");
    }

    public void displaySubjectTaught(String subject) {
        System.out.println(subject + " is being taught");
    }
}
