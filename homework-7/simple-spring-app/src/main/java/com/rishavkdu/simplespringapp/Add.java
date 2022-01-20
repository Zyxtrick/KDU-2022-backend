package com.rishavkdu.simplespringapp;

public class Add implements Operation{

    int num ;

    Add(){
        System.out.println("In default constructor of Add");
        num = 0;
    }

    Add(int num){
        System.out.println("In parameterized constructor of Add");
        this.num = num;
    }

    public void setNum(int num) {
        System.out.println("In setNum of Add");
        this.num = num;
    }
    public void init(){
        System.out.println("In init()of Add");
        num += 50;
    }
     public void getResult(int a) {
         System.out.println("Result : " + (num + a));
    }

    public void destroy(){
        System.out.println("In destroy of Add");
    }
}
