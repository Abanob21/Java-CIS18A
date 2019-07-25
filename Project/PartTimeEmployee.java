public class PartTimeEmployee extends Employee implements EmployeePayment {
    public int hours_worked;
    public PartTimeEmployee(String name, double salary_per_hour) {
        super(name, salary_per_hour);
    }

    public void setHours_worked(int hours_worked){
        this.hours_worked = hours_worked;
    }

    @Override
    public double pay() {
        return hours_worked * super.salary_per_hour;
    }
}
