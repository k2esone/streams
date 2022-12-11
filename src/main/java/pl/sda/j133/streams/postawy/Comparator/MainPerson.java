package pl.sda.j133.streams.postawy.Comparator;

import java.util.*;

public class MainPerson {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>(
                List.of(
                        new Person("Jan", 13),
                        new Person("Marian", 23),
                        new Person("Julia", 21),
                        new Person("Marcelina", 15),
                        new Person("Gaweł", 29)
                )
        );

        personList.sort(Comparator.comparing(person -> person.getName()));
        personList.sort(Comparator.comparing(person -> person.getAge()));

        personList.sort((o1, o2) -> {
            return o1.getName().compareTo(o2.getName());
        });

        Set<Person> personSet = new TreeSet<>((o1, o2) -> {
            return o1.getName().compareTo(o2.getName());
        });
        personSet.addAll(personList);
        personSet.forEach(System.out::println);

        personList.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                int wynikPorownaniaImion = o1.getName().compareTo(o2.getName());
                if (wynikPorownaniaImion == 0) {
                    // dokonujemy porównania wieku ponieważ porównanie imion nie było rozstrzygające
                    return Integer.compare(o1.getAge(), o2.getAge());
                }
                return wynikPorownaniaImion;
            }
        });
    }
}
