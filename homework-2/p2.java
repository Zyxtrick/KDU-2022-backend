import java.util.*;

class P2 {
    
    void countDuplicates(String str)
    {
    
        int count[] = new int[256];
        for (int i = 0; i < str.length(); i++){
            count[str.charAt(i)]++;
        }
 
        System.out.println("Repaeating characters are :");
        for (int i = 0; i < 256; i++){
            if (count[i] > 1){
                System.out.println((char)(i) + " has a count of " + count[i]);
            }  
        }
    }
    
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        P2 obj = new P2();
        obj.countDuplicates(str);

    }
}