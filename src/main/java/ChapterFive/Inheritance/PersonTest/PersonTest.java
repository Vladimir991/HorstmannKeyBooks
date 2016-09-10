package ChapterFive.Inheritance.PersonTest;

public class PersonTest {
    public static void main(String[] args) {
        Person[] people = new Person[2];

        people[0] = new Employee("Andrey Shatalov", 50000, 1972, 10, 1);
        people[1] = new Student("Andrey Grishenko", "computer science");

        for (Person p : people)
            System.out.println(p.getName() + ", " + p.getDescription());
    }
}
