package com.rishavkdu.simplespringapp;

public class CyclicDependancyB {

    private CyclicDependancyA a;

    public CyclicDependancyB(CyclicDependancyA a) {
        System.out.println("Setting property a of B instance");
        this.a = a;
    }
    public CyclicDependancyA getA(){
        return a;
    }


}