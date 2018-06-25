package udemyJAVA8Features;

/**
 * Created by Arpit on 28-06-2017.
 * Filetering collections with predicate interfaces
 */
import JavaBrains.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateInnerClass {

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();

        people.add(new Person("Mark","Robinson",30));
        people.add(new Person("Matt","Cruise",40));
        people.add(new Person("Vin","Diesel",38));

        Predicate<Person> pred = new Predicate<Person>() {
            @Override
            public boolean test(Person p) {
                return (p.getAge()>30);
            }
        };

        for (Person person : people) {
            if (pred.test(person)){
                System.out.println(person.toString());
            }
        }

    }
}
