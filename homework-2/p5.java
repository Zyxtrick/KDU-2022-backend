import java.util.*; 
import java.io.*; 

class P5 {


    void generateIOException(){
        try{
            File newFile = new File("test.txt");
            FileInputStream stream = new FileInputStream(newFile);
        }catch(IOException e){
            System.out.println("An IO exception has occured!");
        }
    }

    void generateNumberFormatException(){
        try{
            Integer.parseInt("null") ;
        }catch(NumberFormatException e){
            System.out.println("An NumberFormatException has occured!");
        }
    }

    void generateArithmeticException(){
        try {
            int a = 5, b = 0;
            int c = a/b;  
        }
        catch(ArithmeticException e) {
            System.out.println ("An Arithmetic Exception has occured!");
        }
    }

    void generateArrayIndexOutOfBoundsException(){
        try{
            int a[] = new int[5];
            a[6] = 9; 
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println ("An ArrayIndexOutOfBoundsException has occured!");
        }
    }

    void demonstrateNestedTryCatchFinally(){
        try{
            try{
                int c = 15/0;
            }
            catch(Exception e){
                System.out.println("Inner try Block has found Exception");
            }
        }
        catch(ArithmeticException e){
            System.out.println("Outer try block has found Exception");
        }finally{
            System.out.println("Finishing remaining statements");
        }
    }


    public static void main(String[] args){
        P5 newobj = new P5();
        newobj.generateIOException();
        newobj.generateNumberFormatException();
        newobj.generateArithmeticException();
        newobj.generateArrayIndexOutOfBoundsException();
        newobj.demonstrateNestedTryCatchFinally();
    }


}