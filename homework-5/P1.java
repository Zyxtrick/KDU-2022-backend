import java.util.*;
import java.lang.*;

class A {
    private int a;

    A() {
        this.a = 1;
    }

    void print() {
        System.out.println("This is A ");
    }
}

class B extends A{
    private int b;
    B(){
        this.b = 2;
    }
    @Override
    void print() {
        System.out.println("This is B ");
    }

}


public class P1 {
   @SuppressWarnings({"unchecked"})

    public static void main(String[] args){
        A a = new B();
        a.print();

        ArrayList list=new ArrayList();
        list.add("sonoo");
        list.add("vimal");
        list.add("ratan");

        for(Object obj:list)
            System.out.println(obj);
    }
}


