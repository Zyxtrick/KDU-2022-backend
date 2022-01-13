import java.util.*;
import java.lang.*;
import org.junit.Test;
import static org.junit.Assert.*;


class Activity{

    int add(int a, int b){
        int sum = a + b;
        return sum;
    }


    boolean checkPallindrome(String s) {
        int len= s.length();
        String rev = "";

        for (int i = len-1; i >=0; --i) {
            rev = rev + s.charAt(i);
        }
        return s.toLowerCase().equals(rev.toLowerCase()) ;
    }
}

public class P3 {
    @Test
    static void unitTesting(){
        Activity a = new Activity();
        boolean result1 = a.checkPallindrome("abacaba"); // Should come to TRUE
        boolean result2 = a.checkPallindrome("John"); // Should come to FALSE
        assertTrue(result1);
        assertTrue(result2);

        int result3 = a.add(9, 10);
        assertEquals(19, result3);
    }


    public static void main(String[] args) {
        System.out.println("Starting unit Tests");
        unitTesting();
    }
}
