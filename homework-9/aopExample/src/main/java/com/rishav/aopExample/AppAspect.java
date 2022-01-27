package com.rishav.aopExample;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AppAspect {

    @Pointcut("execution(* com.rishav.aopExample.student..* (..))")
    public void anyMethodInStudent() {
    }

    @Pointcut("within(com.rishav.aopExample.teacher.*)")
    public void anyMethodInTeacher(){
    }

    @Pointcut("execution(* * (String))")
    public void anyMethodWithStringArguement(){
    }

    @Before("anyMethodInStudent() || anyMethodInTeacher()")
    public void beforeAnyMethod(JoinPoint joinPoint) {
        System.out.println("Before  : " + joinPoint.getSignature().getName());
    }

    @After("anyMethodInStudent() || anyMethodWithStringArguement()")
    public void afterAnyMethod(JoinPoint joinPoint) {
        System.out.println("After  : " + joinPoint.getSignature().getName());
    }

    @AfterReturning("anyMethodInStudent()")
    public void afterReturningAnyMethod(JoinPoint joinPoint) {
        System.out.println("AfterReturning  : " + joinPoint.getSignature().getName());
    }

    @AfterThrowing("anyMethodInStudent()")
    public void afterThrowingAnyMethod(JoinPoint joinPoint) {
        System.out.println("AfterThrowing  : " + joinPoint.getSignature().getName());
    }

    @Around("anyMethodInStudent()")
    public Object aroundgAnyMethod(ProceedingJoinPoint joinPoint) {
        System.out.println("Around  : " + joinPoint.getSignature().getName());
        Object returnValue = null;
        try{
            returnValue = joinPoint.proceed();
            System.out.println("Returned : " + returnValue);
        }
        catch (Throwable e) {
            e.printStackTrace();
        }
        return returnValue;
    }

}
