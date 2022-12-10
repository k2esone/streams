package pl.sda.j133.streams.postawy;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Person person1 = new Person("Jacek", "Kowalski", 18, true);
        Person person2 = new Person("Jacek", "Górski", 15, true);
        Person person3 = new Person("Andżelika", "Dżoli", 25, false);
        Person person4 = new Person("Wanda", "Ibanda", 12, false);
        Person person5 = new Person("Marek", "Marecki", 17, true);
        Person person6 = new Person("Johny", "Brawo", 25, true);
        Person person7 = new Person("Stary", "Pan", 80, true);
        Person person8 = new Person("Newbie", "Noob", 12, true);
        Person person9 = new Person("Newbies", "Sister", 19, false);
        List<Person> people = new ArrayList<Person>(Arrays.asList(person1, person2, person3,
                person4, person5, person6, person7, person8, person9));

        List<Person> streamA = people.stream()
                .filter(m -> m.isMale())
                .collect(Collectors.toList());

        List<Person> streamB = people.stream()
                .filter(m -> m.isMale())
                .filter(a -> a.getAge() >= 18)
                .collect(Collectors.toList());

        Optional<Person> StreamC = people.stream()
                .filter(a -> a.getAge() >= 18)
                .filter(a -> a.getFirstName().equals("Jacek"))
                .findFirst();
        if (StreamC.isPresent()) {
            Person personC = StreamC.get();
            System.out.println(personC);
        }

        List<String> streamD = people.stream()
                .filter(a -> a.getAge() >= 15)
                .filter(a -> a.getAge() <= 19)
                .map(Person::getLastName).toList();

        int streamE = people.stream()
                .mapToInt(a -> a.getAge())
                .sum();

        OptionalDouble streamF = people.stream()
                .filter(m -> m.isMale())
                .mapToInt(a -> a.getAge())
                .average();
        System.out.println(streamF);

        List<Person> StreamG = people.stream()
                .max(Comparator.comparing(Person::getAge))
                .stream().toList();
        System.out.println(StreamG);

    }
}
