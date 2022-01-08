import java.util.*;
import java.io.*;

class ParallelLineException extends Exception
{
    public ParallelLineException(String s)
    {
        super(s);
    }
}

class Line{

    private int m;
    private int c;

    public Line(int m, int c){
        this.m = m;
        this.c = c;
    }

    int getSlope(){
        return m;
    }

    int getYIntercept(){
        return c;
    }

    

    void findIntersection(Line obj) throws ParallelLineException{
            int m1 = obj.getSlope();
            int c1 = obj.getYIntercept();
            if(m1 == m){
               throw new ParallelLineException("Cannot find Intersection Parallel Lines!"); 
            }
            double x = (c - c1)/(m1 - m);
            double y = m*x + c;
            System.out.println("Interesection is "+ x + " and "+ y);
        
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Line 1 : ");
        System.out.println("Slope : ");
        int m1 = sc.nextInt();
        System.out.println("Y-Interecept : ");
        int c1 = sc.nextInt();

        System.out.println("Line 2 : ");
        System.out.println("Slope : ");
        int m2 = sc.nextInt();
        System.out.println("Y-Interecept : ");
        int c2 = sc.nextInt();
        
        Line l1 = new Line(m1, c1);
        Line l2 = new Line(m2, c2);


        try{
            l1.findIntersection(l2);
        }catch(ParallelLineException e){
            System.out.println("Cannot find intersection as lines are parallel!");
        }catch(ArithmeticException e){
            System.out.println("Cannot find intersection as an Arithmetic exception has occured!");
        }catch(Exception e){
            System.out.println("Cannot find intersection as some exception has occured!");
        }
    }
}
