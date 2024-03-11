
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



interface Employee {
    public int getId();
    public String getName();
    public double getSalary();
    public void print();
    public void add(Employee employee);
    public void remove(Employee employee);
    public Employee getChild(int i);
}


class BankManager implements Employee {
    private int id;
    private String name;
    private double salary;
    public BankManager(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    List<Employee> employees = new ArrayList<Employee>();
    @Override
    public void add(Employee employee) {
        employees.add(employee);
    }
    @Override
    public Employee getChild(int i) {
        return employees.get(i);
    }
    @Override
    public void remove(Employee employee) {
        employees.remove(employee);
    }
    @Override
    public int getId() {
        return id;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public double getSalary() {
        return salary;
    }
    @Override
    public void print() {
        System.out.println("======================================");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
        System.out.println("======================================");

        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            iterator.next().print();
        }
        Iterator<Employee> it = employees.iterator();
        while(it.hasNext()){
            Employee employee = it.next();
            employee.print();
        }
    }
}



class Cashier implements Employee {
    private int id;
    private String name;
    private double salary;
    public Cashier(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    @Override
    public int getId(){
        return id;
    }
    @Override
    public String getName(){
        return name;
    }
    @Override
    public double getSalary(){
        return salary;
    }
    
    // /---------------------------------------------------------------------
    @Override 
    public void add(Employee employee){
        // non
    }
    @Override
    public void remove(Employee employee){
        // non
    }
    @Override
    public Employee getChild(int i){
        return null;
    }
    // /---------------------------------------------------------------------

    public void print(){
        System.out.println("======================================");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
        System.out.println("======================================");
    }
}











class Accountant implements Employee {
    private int id;
    private String name;
    private double salary;
    public Accountant(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    @Override
    public int getId(){
        return id;
    }
    @Override
    public String getName(){
        return name;
    }
    @Override
    public double getSalary(){
        return salary;
    }
    
    // /---------------------------------------------------------------------
    @Override 
    public void add(Employee employee){
        // non
    }
    @Override
    public void remove(Employee employee){
        // non
    }
    @Override
    public Employee getChild(int i){
        return null;
    }
    // /---------------------------------------------------------------------

    @Override
    public void print(){
        System.out.println("======================================");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
        System.out.println("======================================");
    }
}






public class CompositePatternDemo {
    public static void main(String[] args) {
        Employee emp1 = new Cashier(101, "Shonan Kumar", 200000);
        Employee emp2 = new Cashier(102, "Mohan Kumar", 250000);
        Employee emp3 = new Accountant(103, "Seema Mahiwal", 300000);
        Employee manager = new BankManager(104, "Ashwani Rajput", 350000);
        manager.add(emp1);
        manager.add(emp2);
        manager.add(emp3);
        manager.print();
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        manager.remove(emp2);
        manager.remove(emp3);
        manager.print();

    }
}