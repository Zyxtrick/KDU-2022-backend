import java.util.*;
import java.lang.*;
import java.lang.annotation.*;
import java.lang.reflect.*;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CookedBy{
    String chef() default "Sam";
}

class Menu {
    @CookedBy(chef= "Oliver")
    void orderPizza() {
        System.out.println("Your Pizza is ready");
    }

    @CookedBy(chef= "Hassan")
    void orderBiriyani() {
        System.out.println("Your Biriyani is ready");
    }

    @CookedBy(chef= "Susan")
    void orderCake() {
        System.out.println("Your Cake is ready");
    }
}


public class P2 {
    public static void main(String[] args) {
        Menu johnMenu = new Menu();
        johnMenu.orderPizza();
        johnMenu.orderBiriyani();
        johnMenu.orderCake();
    }
}
