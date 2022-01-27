package com.rishav.aopExample.student;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Component
public class Student {
    private String name;
    private int averageMarks;

    public int getAverageMarks(int marksComputer, int marksEnglish, int marksScience){
        averageMarks = (marksComputer + marksEnglish + marksScience)/3;
        int a = 0, b = 9;
//        System.out.println(b/a);
        return averageMarks;
    }

}
