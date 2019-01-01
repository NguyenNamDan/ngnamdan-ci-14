public class Dog extends Animal {
    String country;


    // hàm tạo
    public Dog(String name, int age, String country) {
        this.name = name;
        this.age = age;
        this.country = country;
    }

    // run()

    @Override
    void run() { // ~ dog.run()
        super.run(); // ~ animal.run()
        System.out.println("Dog running..");
    }
}
