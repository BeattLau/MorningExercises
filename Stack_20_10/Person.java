package Stack_20_10;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int compareTo(Person other) {
        return Integer.compare(this.age, other.age);
    }

    @Override
    public String toString() {
        return name + " (Age: " + age + ")";
    }

    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("A", 1));
        persons.add(new Person("B", 4));
        persons.add(new Person("E", 3));
        persons.add(new Person("D", 5));
        persons.add(new Person("C", 2));

        System.out.println("List before sorting:");
        System.out.println(persons);

        Collections.sort(persons);

        System.out.println("List after sorting by age:");
        System.out.println(persons);
    }
}
