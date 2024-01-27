import java.util.*;

class P3 {
    
    void printNonRepeatingCharacters(String str)
    {
    
        int count[] = new int[256];
        System.out.println("The string after removing duplicate characters becomes : ");
        for (int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            count[ch]++;
            if(count[ch] == 1) System.out.print(ch);
        }
    }
    
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        P3 obj = new P3();
        obj.printNonRepeatingCharacters(str);
    }
}