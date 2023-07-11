package Hash;

// import java.util.HashMap;
import java.util.HashSet;

class Person {
    private String name;
    private int age;
    private static HashSet<String> set = new HashSet<>();
    Person(String name, int age) {
        // System.out.println(name + " " + age);
        boolean createInstance = isUnique(name, age);
        if(!createInstance){
            throw new RuntimeException("Error in arguments sent");
        }
        this.name = name;
        this.age = age;
        set.add(name + Integer.toString(age));
    }

    private boolean isUnique(String name, int age){
        return !set.contains(name + Integer.toString(age));
    }

    public void display() {
        System.out.println("Name is : " + this.name);
        System.out.println("Age is : " + this.age + "\n");
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }
}

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("nithin", 20);
        Person p2 = new Person("pinku", 20);
        Person p3 = new Person("pinku", 20);
    }
}
