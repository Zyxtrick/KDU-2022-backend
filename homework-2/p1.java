import java.util.*;
  
class Credentials {
    static Credentials creds = null;
    private int x = 5;
    private String s = "Hello";

    private Credentials() {

    }

    int getX() { return x; }
    String getS() { return s; }

    static public Credentials getInstance() {
        creds = new Credentials();
        return creds;
    }

}

class P1 {
    public static void main(String args[]) {
       
       Credentials a = Credentials.getInstance();
       System.out.println(a.getX() + " " + a.getS());
   }    
}