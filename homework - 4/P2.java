import java.util.*;
import java.util.stream.IntStream;

class P2 {
    public static void main(String[] args){

        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        for(int i=0;i<Math.pow(10, 6);i++) {
            arrayList.add(i);
        }

        long start1 = System.nanoTime();
        for(int i=0;i<arrayList.size(); i++){
            System.out.print(arrayList.get(i));
        }
        long end1 = System.nanoTime();



        long start2 = System.nanoTime();
        arrayList.stream().forEach(System.out::print);
        long end2 = System.nanoTime();


        long start3 = System.nanoTime();
        arrayList.parallelStream().forEach(System.out::print);
        long end3 = System.nanoTime();

        System.out.println();
        System.out.println("Elapsed Time in nano seconds for for loop            : "+ (end1-start1));
        System.out.println("Elapsed Time in nano seconds for non-parallel stream : "+ (end2-start2));
        System.out.println("Elapsed Time in nano seconds for Parallel Stream     : "+ (end3-start3));




    }
}
