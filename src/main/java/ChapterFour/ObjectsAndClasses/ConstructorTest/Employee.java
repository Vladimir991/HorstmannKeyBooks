package ChapterFour.ObjectsAndClasses.ConstructorTest;

import java.util.Random;

public class Employee {
    private static int nextId;

    private int id;
    private String name = "";
    private double salary;

    static {
        Random generator = new Random();
        nextId = generator.nextInt(10000);
    }

    {
        id = nextId;
        nextId++;
    }

    public Employee(String n, double s) {
        name = n;
        salary = s;
    }

    public Employee(double s) {
        // the constructor to be called Employee(String, double)
        this("Employee #" + nextId, s);
    }

    // a no-argument constructor
    public Employee() {

    }


    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    public double getSalary() {
        return salary;
    }
}
