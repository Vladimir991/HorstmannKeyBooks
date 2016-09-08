package ChapterFive.Inheritance.ManagerTest;

public class ManagerTest {
    public static void main(String[] args) {
        Manager boss = new Manager("Vladimir Vladimirov", 80000, 1975, 8, 15);
        boss.setBonus(5000);

        Employee[] staff = new Employee[3];
        staff[0] = boss;
        staff[1] = new Employee("Andrey Grishenko", 50000, 1976, 10, 1);
        staff[2] = new Employee("Andrey Shatalov", 40000, 1990, 3, 15);

        for (Employee e : staff)
            System.out.println("name " + e.getName() + ", salary = " + e.getSalary());
    }
}
