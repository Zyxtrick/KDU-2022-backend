import java.io.*;
import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Product {
    private String name;
    private int price;

    Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    String getName() { return this.name; }
    int getPrice() { return this.price; }

    public String toString() {
        return this.name + " "+ this.price;
    }
}

class P1 {

    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<Product>();

        // Scanner sc = new Scanner(System.in);
        // for(int i=0; i<N; i++){
        //     System.out.println("Name : ");
        //     String name  = sc.nextLine();
        //     System.out.println("Price : ");
        //     int price  = sc.nextInt();
        //     products.add(new Product(name, price));
        // }

        products.add(new Product("A", 10));
        products.add(new Product("B", 20));
        products.add(new Product("C", 30));
        products.add(new Product("D", 40));
        products.add(new Product("Z", 50));
        products.add(new Product("G", 60));
        products.add(new Product("E", 70));
        products.add(new Product("R", 80));



        // To demonstrate the use of Max
        Product maxProduct = products.stream()
                .max(Comparator.comparingInt(Product::getPrice))
                .get();
        System.out.println("The max product is of price " + maxProduct.getPrice());

        //To demonstrate the use of Min
        Product minProduct = products.stream().
                min(Comparator.comparingInt(Product::getPrice))
                .get();
        System.out.println("The min product is of price " + minProduct.getPrice());

        //To demonstrate anyMatch()
        System.out.print("Is Product with price 30 present ? ");
        boolean answer1 = products.stream()
                .anyMatch(p -> p.getPrice() == 30);
        System.out.println(answer1);

        //To demonstrate anyMatch()
        System.out.print("Do all products have price greater than 20 : ");
        boolean answer2 = products.stream()
                .allMatch(p -> p.getPrice() > 20);
        System.out.println(answer2);

        System.out.print("Do all products have price less than 100 : ");
        boolean answer3 = products.stream().
                allMatch(p -> p.getPrice() < 100);
        System.out.println(answer3);

        //To demonstrate filter()
        System.out.println("Print all products with price greater than 20 : ");
        products.stream()
                .filter(p -> p.getPrice() > 20)
                .forEach(System.out::println);

        //To demonstrate sorted()
        System.out.println("Print all products sorted by name : ");
        products.stream()
                .sorted((p1, p2)->p1.getName().compareTo(p2.getName()))
                .forEach(System.out::println);

        //To demonstrate groupingBy
        System.out.println("Print count of all products:");
        Map<String, Long> counting = products.stream().collect(
                Collectors.groupingBy(Product::getName, Collectors.counting()));

        System.out.println(counting);

        //Finding average price of all products
        OptionalDouble averagePrice = products.stream().map(p-> p.getPrice()).mapToInt(Integer::intValue).average();
        System.out.println("Average price is :"+ averagePrice);

        //Finding the sum of all the prices after incrementing the prices by 25
        Optional<Double> sum = products.stream().map(p-> p.getPrice()*1.25).reduce((p1, p2) -> p1+p2);
        System.out.println("sum of all the prices after incrementing the prices by 25% is "+sum);
    } 

}