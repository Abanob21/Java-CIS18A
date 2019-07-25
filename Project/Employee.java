public class Employee {
    protected String name; //To hold employee name
    protected double salary_per_hour; //To hold the salary of the employee per hour

    public Employee(String name,double salary_per_hour){
        this.name = name;
        this.salary_per_hour = salary_per_hour;
    }

    public String getName() {
        return name;
    }
}