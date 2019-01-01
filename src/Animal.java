public class Animal {
    //thuộc tính
    String name;
    int age;

    public Animal() {

    }

    // hàm tạo
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // phương thức
    void run() {
        System.out.println(this.name + " running..");
    }

    void eat() {
        System.out.println(this.name + " eating..");
    }

    void sleep() {
        System.out.println(this.name + " leeping..");
    }
}
