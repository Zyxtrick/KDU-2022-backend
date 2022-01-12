import java.util.*;

class Employee{
    private String name;
    private int salary;
    private int equityShare;

    Employee(String n, int s, int e){
        super();
        name = n;
        salary = s;
        equityShare = s;
    }

    String getName() {  return this.name; }
    int getSalary() {  return this.salary; }
    int getEquityShare() {  return this.equityShare; }

    @Override
    public boolean equals(Object o){
        Employee e = (Employee) o;
        return e.salary == this.salary;
    }

}

class P1{

    public static Employee getNewMember(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Name : ");
        String name = sc.nextLine();
        System.out.println("Salary : ");
        int salary = sc.nextInt();
        System.out.println("Equity Share : ");
        int eqShare = sc.nextInt();

        Employee e = new Employee(name, salary, eqShare);
        return e;
    }

    public static void print(ArrayList<Employee> empList)
    {
        for (Employee e : empList) {
            System.out.println(e.getName() + " " + e.getSalary());
        }
    }


    public static void main(String[] args){
        ArrayList<Employee> empList = new ArrayList<>();
        
        for(int i=0;i<5;i++){
            empList.add(getNewMember());
        }

        empList.sort((e1, e2) -> e1.getName().compareTo(e2.getName()));
        print(empList);

        System.out.println("Comparision of salaries using equals : ");
        System.out.println(empList.get(1) + " " +empList.get(2));
        System.out.println(empList.get(1).equals(empList.get(2)));
        

    }
}