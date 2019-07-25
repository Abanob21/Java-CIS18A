public class FulltimeEmployee extends Employee implements EmployeePayment {
    public int hours_per_day;

    public FulltimeEmployee(String name, double salary_per_hour,int hours_per_day) {
        super(name, salary_per_hour);
        this.hours_per_day = hours_per_day;
    }

    @Override
    public double pay() {
        return super.salary_per_hour * hours_per_day ;
    }
}
