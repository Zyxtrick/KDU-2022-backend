import java.util.*;

class P4{

	// abababd
	// ababd
	static int findLastIndexKMP(String s2, String s1)
	{
		int ans = -1, m = s2.length(), n = s1.length();
        
        int lps[] = new int[m]; 
		calculateLPS(s2, m, lps);

		int i = 0, j = 0; 
        while (i < n) {
			if (s2.charAt(j) == s1.charAt(i)) {
				j++;
				i++;
			}
			if (j == m) {
				ans = i - j;
                //System.out.println(ans);
				j = lps[j-1];
			}
        	else if (i < n && s2.charAt(j) != s1.charAt(i)) {
        		if (j != 0)
					j = lps[j - 1];
				else
					i = i + 1;
			}
		}
        return ans;
	}

	static void calculateLPS(String s2, int M, int lps[])
	{
		int len = 0, i = 1;
		lps[0] = 0;
        while (i < M) {
			if (s2.charAt(i) == s2.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			} else {
            	if (len != 0) {
					len = lps[len - 1];
				} else {
					lps[i] = len;
					i++;
				}
			}
		}
	}

    public static void main(String args[]) {
		String s1, s2;
        Scanner sc = new Scanner(System.in);
        
		System.out.println("Enter s1 : ");
        s1 = sc.nextLine();
        
		System.out.println("Enter s2 : ");
        s2 = sc.nextLine();
		
		System.out.println("Enter insertionIndex :");
        int insertionIdx = sc.nextInt();
		
		int i = findLastIndexKMP(s2, s1);
		i = i+1;
        if(i != -1) System.out.println("Task1 : Pattern found at " + i);
        else System.out.println("Task 1 : -1 Pattern not found");

		if( insertionIdx > s1.length() ) System.out.println("Task 2 : Not possible to insert out of bounds");
		else{
			String newString = s1.substring(0, insertionIdx) + s2 + s1.substring(insertionIdx);
			System.out.println("Task 2 : "+ newString);
		}
	}
}

