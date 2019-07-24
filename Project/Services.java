public class Services implements service {
    private String name;
    //The above 'name' variable is used to hold the Name of the service.

    private double price_for_underage,price_for_overage;
    //The above two variables are used to hold prices for Services according to age

    /*
    * We are going to have only one constructor which accepts the various data
    * of various Services offered in the beauty salon
    */
    public Services(String name, double price_for_underage, double price_for_overage){
        this.name = name;
        this.price_for_overage = price_for_overage;
        this.price_for_underage = price_for_underage;

        //The This key word id used to that we can differenciate between the instance variable
        // and the constructor parameters
    }

    /*
        This method is inherited from the interface and it is used to calculate the amount one to pay
        for the service offered.
    */
    @Override
    public double calculateCost(int age) {

        if(age<=17){
            return price_for_underage;
        }else{
            return price_for_overage;
        }
    }

    //This method is a getter used to get service name
    public String getName() {
        return name;
    }
}
