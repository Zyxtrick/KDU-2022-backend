import java.io.*;
import java.util.*;

class P2{


    public static void printFirstTenLines(){
        BufferedReader br = null;
        try{	
            br = new BufferedReader(new FileReader("country-list.csv"));		    
            System.out.println("Reading first 10 lines ");
            String contentLine = br.readLine();
            
            int count = 1;
            while (count <= 10 && contentLine != null) {
                System.out.println(count + " : "+ contentLine);
                contentLine = br.readLine();
                count += 1;
            }


        } catch (IOException e){
            System.out.println("IOException!");
        }
    }

    public static String[] seperateCountryCapital(String s){
        String[] countryCapital = new String[2];
        String country="", capital="";

        int i;
        for(i=1; i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '"') break;
            country += ch;
        }
        for(i = i+3 ; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '"') break;
            capital += ch;
        }
        countryCapital[0] = country;
        countryCapital[1] = capital;
        return countryCapital;
    }

    public static LinkedHashMap sortMap(LinkedHashMap map) {
        List <Map.Entry<String, String>> capitalList = new LinkedList<>(map.entrySet());
        
        Collections.sort(capitalList, (l1, l2) -> l1.getValue().compareTo(l2.getValue()));

        LinkedHashMap<String, String> result = new LinkedHashMap();

        for (Map.Entry<String, String> entry : capitalList) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }


    public static void main(String[] args){
        printFirstTenLines();
        BufferedReader br = null;
        // String[] cclist = new String[2];
        LinkedHashMap<String, String> hmap = new LinkedHashMap();
        try{	
            br = new BufferedReader(new FileReader("country-list.csv"));		    
            String contentLine = br.readLine();
            while (contentLine != null) {
                // System.out.println(contentLine);
                contentLine = br.readLine();
                if(contentLine != null) {
                    String[] cclist = seperateCountryCapital(contentLine);
                    // System.out.println(cclist[0] +" " + cclist[1]);
                    hmap.put(cclist[0], cclist[1]);
                }                
            }
        } catch (IOException e){
            System.out.println("IOException!");
        }

        Map<String, String> result = sortMap(hmap);

        int n = result.size();
        System.out.println("Last 10 lines : ");
        for(Map.Entry e : result.entrySet()){
            if(n <= 10) System.out.println( e.getKey() + "  " + e.getValue());
            n -= 1;
        }
    }
     








    
}