package ChapterFive.Inheritance.EqualsTest;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;

public class Employee {
    private String name;
    private double salary;
    private Date hireDay;

    public Employee(String n, double s, int year, int month, int day) {
        name = n;
        salary = s;
        GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
        hireDay = calendar.getTime();
    }


    public String getName() {
        return name;
    }


    public double getSalary() {
        return salary;
    }

    public Date getHireDay() {
        return hireDay;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    public boolean equals(Object otherObject) {

        // quickly check objects for similarity
        if (this == otherObject)
            return true;
        // if an explicit parameter is blank null,
        // must be returned a Boolean value false
        if (otherObject == null)
            return false;
        // if the classes are not the same, they are not equivalent
        if (getClass() != otherObject.getClass())
            return false;

        Employee other = (Employee) otherObject;
        // to check whether the fields contain the same values
        return Objects.equals(name, other.name) && salary == other.salary &&
                Objects.equals(hireDay, other.hireDay);
    }

    public int hashCode() {
        return Objects.hash(name, salary, hireDay);
    }

    public String toString() {
        return getClass().getName() + "[name = " + name +
                ", salary = " + ", hireDay = " + hireDay + "]";
    }
}
