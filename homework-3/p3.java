import java.util.*;

class A<T> {
    
    T obj;
    A(T o) {  obj = o;  }  
    
    public T get()  { return obj; }
    
    public < T > void print(T[] arr) {  
        for ( T t : arr){          
            System.out.println(t);  
         }  
         System.out.println();  
    } 
}

class P3
{
    public static < T > void print(T[] arr) {  
        for ( T t : arr){          
            System.out.println(t);  
         }  
         System.out.println();  
    }

    public static void main (String[] args)
    {
        
        //Generic Class example

        A <Integer> objInteger = new A<Integer>(10);
        System.out.println(objInteger.get());
   
        A <String> objString =  new A<String>("kickdrum");
        System.out.println(objString.get());



        //Generic Methods Example 
        Integer[] intArray = { 1,2,3,4,5 };  
        Character[] charArray = { 'K', 'i', 'c', 'k', 'd', 'r', 'u', 'm' };  
  

        System.out.println( "Integer Array" );  
        print( intArray  );   
  
        System.out.println( "Character Array" );  
        print( charArray );  


        //Generic Collection Example
        ArrayList list = new ArrayList();
        list.add("A");
        list.add("B");
        list.add(10); 
  
        try{
            String s1 = (String)list.get(0);
            String s2 = (String)list.get(1);
            String s3 = (String)list.get(2);
        }catch(Exception e){
            System.out.println("An Exception has occured!");
        }

        ArrayList <String> glist = new ArrayList<String> ();
  
        glist.add("A");
        glist.add("B");
        //gl.add(10);
  
        try{
            String s1 = (String)glist.get(0);
            String s2 = (String)glist.get(1);
        }catch(Exception e){
            System.out.println("An Generic Exception has occured!");
        }



        
    }
}