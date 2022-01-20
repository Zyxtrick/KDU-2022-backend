package com.rishavkdu.simplespringapp;

public class CyclicDependancyA {

    private CyclicDependancyB b;

    public CyclicDependancyA(CyclicDependancyB b) {
        System.out.println("Setting property b of A instance");
        this.b = b;
    }

    public CyclicDependancyB getB(){
        return b;
    }

}