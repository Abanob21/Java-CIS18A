public class Client{
    private String name;
    private int age;
    private Services services;

    public Client(String name, int age, Services services) {
        this.name = name;
        this.age = age;
        this.services = services;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Services getServices() {
        return services;
    }

}
