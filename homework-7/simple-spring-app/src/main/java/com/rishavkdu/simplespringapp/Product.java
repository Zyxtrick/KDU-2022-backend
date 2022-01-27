package com.rishavkdu.simplespringapp;

public class Product implements Operation{

    private int num ;

    Product(){
        System.out.println("In default constructor of Product");
        num = 1;
    }
    Product(int num){
        System.out.println("In parameterized constructor of Product");
        this.num = num;
    }

    public void setNum(int num){
        System.out.println("In setNum of Product");
        this.num = num;
    }
    public void init(){
        System.out.println("In init() of Product");
        num = num * 50;
    }

    public void getResult(int a) {
        System.out.println("Result : " + (num*a));
    }

    public void destroy(){
        System.out.println("In destroy of Product");
    }
}
