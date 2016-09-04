package ChapterFour.ObjectsAndClasses.EmployeeTest;

public class EmployeeTest {
    public static void main(String[] args) {

        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Andrey Shatalov", 75000, 1972, 18, 15);
        staff[1] = new Employee("Dmitry Kleyn", 50000, 1972, 19, 1);
        staff[2] = new Employee("Andrey Grichenko", 40000, 1976, 3, 15);

        for (Employee e : staff)
            e.raiseSalary(5);

        for (Employee e : staff)
            System.out.println("name = " + e.getName() + ", salary = "
                    + e.getSalary() + ", hireDay = " + e.getHireDay());
    }
}
