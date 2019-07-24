import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Dashboard {
    private static String[] main_menu = {"1. Add Employee","2. Add a service","3. Service a Client","4. View Records","5. Exit"};

    private  static Scanner scanner = new Scanner(System.in); //Initializing scanner to use for getting data

    private static List<Services> services_offered = new ArrayList<>(); // This array is used to hold all the  Services offered

    private static List<FulltimeEmployee> fulltimeEmployees = new ArrayList<>();

    private static List<PartTimeEmployee> partTimeEmployees = new ArrayList<>();

    private static List<Client> clients = new ArrayList<>();


    public  static void main(String args[]){

        mainMenu();
    }
    /*
    * The main menu provides a list of option a user can choose from. The options are stored in a string array
    * we use the loop so as to list the options as a menu to the user
    * In the whole project we ar using scanner which is used to get user input
    * */
    public static void mainMenu(){
        //Giving the user information on what to do
        System.out.println("Please select an action that you want to perform");
        //Printing thr first main menu using a for loop
        for (String option: main_menu) {
            System.out.println(option);
        }
        System.out.print("selection>");
        int selection = scanner.nextInt();
        switch (selection){
            case 1:
                addEmployee();
                break;
            case 2:
                addServices();
                break;
            case 3:
                serviceClient();
                break;

            case 4:
                viewRecords();
                break;
            case 5:
                System.out.println("Exit");
                break;
            default:
                System.out.println("Please Select a Valid Option");
                break;
        }
    }



    /*
    * This method id used to add services to the system i.e the staff adds the services being
    * offered in the beauty salon.
    * The services are stores in an arraylist called service_offered for later reference.
    * */
    public static void addServices(){
        System.out.println("Please Enter The Service Name");
        String service_name = scanner.next();
        System.out.println("Please Specify the price for under age");
        double underage_price = scanner.nextDouble();
        System.out.println("Please Specify the price for adults");
        double overage_price = scanner.nextDouble();

        Services services = new Services(service_name,underage_price,overage_price);
        services_offered.add(services);
        System.out.println("Service Added successfully.\nEnter 1 to add another service or 2 to Go back to main menu");
        int selection = scanner.nextInt();
        if (selection == 1){
            addServices();
        }else {
            mainMenu();
        }
    }

    /*
    * This method is used to add employees to the beauty palor. The employee can be a part time or full time
    * Fulltime employees use the 'FullTimeEmployee' class while the part time uses 'partTimeEmployess' class
    * The employees objects are held in the arraylist
    * */

    public static void addEmployee(){
        String[] employee_type = {"1. Full-time Employee","2. Part-time Employee"};
        System.out.println("Please Specify employee type");
        for (String option: employee_type) {
            System.out.println(option);
        }
        System.out.print("selection>");
        int selection = scanner.nextInt();
        //Branching according to selection
        if (selection == 1){
            System.out.println("Please Enter The employee First Name");
            String employee_name = scanner.next();
            System.out.println("Please Enter Employee Salary per Hour");
            double salary_per_hour = scanner.nextDouble();
            System.out.println("Please Specify the number of Hours he works per day");
            int hours = scanner.nextInt();

            FulltimeEmployee fulltime = new FulltimeEmployee(employee_name,salary_per_hour,hours);
            fulltimeEmployees.add(fulltime);
            System.out.println("Employee Added successfully.\nEnter 1 to add another Employee or 2 to Go back to main menu");
            int selection2 = scanner.nextInt();
            if (selection2 == 1){
                addEmployee();
            }else {
                mainMenu();
            }
        }else if(selection == 2){
            System.out.println("Please Enter The employee Name");
            String employee_name = scanner.next();
            System.out.println("Please Enter Employee Salary per Hour");
            double salary_per_hour = scanner.nextDouble();


            PartTimeEmployee partTimeEmployee = new PartTimeEmployee(employee_name,salary_per_hour);
            partTimeEmployees.add(partTimeEmployee);
            System.out.println("Employee Added successfully.\nEnter 1 to add another Employee or 2 to Go back to main menu");
            int selection2 = scanner.nextInt();
            if (selection2 == 1){
                addEmployee();
            }else {
                mainMenu();
            }
        }else{
            System.out.println("Please select a valid option");
            addEmployee();
        }
    }

    public static void serviceClient(){
        if (services_offered.size() == 0){
            System.out.println("No services Available. Pres any key And hit ENTER to Go Back");
            String acrion = scanner.next();
            mainMenu();
            return;
        }
        System.out.println("Please select a Service");
        for(int i = 0;i<services_offered.size();i++){
            int number = i+1;
            System.out.println(""+number+". "+services_offered.get(i).getName());
        }
        System.out.print("selection>");
        int selection = scanner.nextInt();

        System.out.println("Please Enter The Client Name");
        String client_name = scanner.next();
        System.out.println("Please Enter Client's Age");
        int age = scanner.nextInt();

        Client client = new Client(client_name,age,services_offered.get(selection-1));
        clients.add(client);
        System.out.println("Total Cost : cash. "+services_offered.get(selection-1).calculateCost(age));
        System.out.println("Client Serviced successfully.\nEnter 1 to Service another Client or 2 to Go back to main menu");
        int selection2 = scanner.nextInt();
        if (selection2 == 1){
            serviceClient();
        }else {
            mainMenu();
        }

    }

    public static void recordParttime(){
        if (services_offered.size() == 0){
            System.out.println("No Employee Available. Pres any key And hit ENTER to Go Back");
            String acrion = scanner.next();
            mainMenu();
            return;
        }
        System.out.println("Please select an Employee");
        for(int i = 0;i<=partTimeEmployees.size();i++){
            System.out.println(""+i+1+". "+partTimeEmployees.get(i).getName());
        }
        System.out.print("selection>");
        int selection = scanner.nextInt();

        System.out.println("Please Enter The Hours Worked");
        int hours_worked = scanner.nextInt();
        partTimeEmployees.get(selection-1).setHours_worked(hours_worked);
        System.out.println("Record Serviced successfully.\nEnter 1 to Record another employee or 2 to Go back to main menu");
        int selection2 = scanner.nextInt();
        if (selection2 == 1){
            serviceClient();
        }else {
            mainMenu();
        }
    }

    public static void viewRecords(){

        String[] records = {"1. Full-Time Employees","2. Part-Time Employees","3. Clients Records","0. To Exit to Main menu"};
        System.out.println("Specify The records you want to View");
        for (String option: records) {
            System.out.println(option);
        }
        System.out.print("selection>");
        int selection = scanner.nextInt();
        if (selection == 0){
            mainMenu();
        }else if(selection == 1){
            viewFullTimeEmployees();
        }else if (selection == 2){
            viewPartTimeEmployees();
        }else if (selection == 3){
            viewClients();
        }
    }

    public static void viewFullTimeEmployees(){
        if (fulltimeEmployees.size() == 0){
            System.out.println("No Full time Employee Available. Pres any key And hit ENTER to Go Back");
            String acrion = scanner.next();
            mainMenu();
            return;
        }
        System.out.println("Full Time Employees");
        System.out.println("____________________________________");
        double total = 0.0;
        for (FulltimeEmployee employee:fulltimeEmployees) {
            total = total +employee.pay();
            System.out.println("Name         : "+employee.getName());
            System.out.println("Hours Worked : "+employee.hours_per_day);
            System.out.println("Salary       : "+employee.pay());
            System.out.println("____________________________________");
        }

        System.out.println("Total Salary: cash. "+total);
        System.out.println("____________________________________");
        System.out.println("Pres any key And hit ENTER to Go Back");
        String acrion = scanner.next();
        viewRecords();

    }

    public static void viewPartTimeEmployees(){
        if (services_offered.size() == 0){
            System.out.println("No Part Time Employee Available. Pres any key And hit ENTER to Go Back");
            String acrion = scanner.next();
            mainMenu();
            return;
        }
        System.out.println("Part Time Employees");
        System.out.println("____________________________________");
        double total = 0.0;
        for (PartTimeEmployee employee:partTimeEmployees) {
            total = total +employee.pay();
            System.out.println("Name         : "+employee.getName());
            System.out.println("Hours Worked : "+employee.hours_worked);
            System.out.println("Salary       : "+employee.pay());
            System.out.println("____________________________________");
        }
        System.out.println("Total Salary: cash. "+total);
        System.out.println("____________________________________");
        System.out.println("Pres any key And hit ENTER to Go Back");
        String acrion = scanner.next();
        viewRecords();

    }


    public static void viewClients(){
        if (services_offered.size() == 0){
            System.out.println("No Client has been Server. Pres any key And hit ENTER to Go Back");
            String acrion = scanner.next();
            mainMenu();
            return;
        }
        System.out.println("Clients Served");
        System.out.println("____________________________________");
        double total = 0.0;
        for (Client client:clients) {
            double cost = client.getServices().calculateCost(client.getAge());
            total = total + cost;
            System.out.println("Name    : "+client.getName());
            System.out.println("Age     : "+client.getAge());
            System.out.println("Service : "+client.getServices().getName());
            System.out.println("Cost    : "+cost);
            System.out.println("____________________________________");
        }
        System.out.println("Total Income: cash . "+total);
        System.out.println("____________________________________");

        System.out.println("Pres any key And hit ENTER to Go Back");
        String acrion = scanner.next();
        viewRecords();

    }


}
