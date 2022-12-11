package pl.sda.j133.streams.postawy.homework;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        List<String> languages1 = Arrays.asList("Java;Cobol;Cpp;Lisp".split(";"));
        List<String> languages2 = Arrays.asList("Java;Lisp".split(";"));
        List<String> languages3 = Arrays.asList("Java;Cobol;Cpp;Lisp;C#".split(";"));
        List<String> languages4 = Arrays.asList("C#;C;Cpp".split(";"));
        List<String> languages5 = Arrays.asList("Java;Assembler;Scala;Cobol".split(";"));
        List<String> languages6 = Arrays.asList("Java;Scala".split(";"));
        List<String> languages7 = Arrays.asList("C#;C".split(";"));
        List<String> languages8 = Collections.emptyList();
        List<String> languages9 = Arrays.asList("Java");
        Programmer programmer1 = new Programmer(person1, languages1);
        Programmer programmer2 = new Programmer(person2, languages2);
        Programmer programmer3 = new Programmer(person3, languages3);
        Programmer programmer4 = new Programmer(person4, languages4);
        Programmer programmer5 = new Programmer(person5, languages5);
        Programmer programmer6 = new Programmer(person6, languages6);
        Programmer programmer7 = new Programmer(person7, languages7);
        Programmer programmer8 = new Programmer(person8, languages8);
        Programmer programmer9 = new Programmer(person9, languages9);
        List<Programmer> programmers = Arrays.asList(
                programmer1,
                programmer2,
                programmer3,
                programmer4,
                programmer5,
                programmer6,
                programmer7,
                programmer8,
                programmer9);
//        System.out.println(programmers);


        List<Programmer> StreamA = programmers.stream()
                .filter(programmer -> programmer.getPerson().isMale())
                .collect(Collectors.toList());

        List<Programmer> StreamB = programmers.stream()
                .filter(programmer -> programmer.getPerson().getAge() < 18)
                .filter(programmer -> programmer.getLanguages().contains("Cobol"))
                .collect(Collectors.toList());
        System.out.println(StreamB);

        List<Programmer> StreamC = programmers.stream()
                .filter(programmer -> programmer.getLanguages().size() >= 2)
                .collect(Collectors.toList());

        List<Programmer> StreamD = programmers.stream()
                .filter(programmer -> !programmer.getPerson().isMale())
                .filter(programmer -> programmer.getLanguages().contains("Java") && programmer.getLanguages().contains("Cpp"))
                .collect(Collectors.toList());

        List<String> StreamE = programmers.stream()
                .filter(programmer -> programmer.getPerson().isMale())
                .map(programmer -> programmer.getPerson().getFirstName())
                .collect(Collectors.toList());

        Set<String> StreamF = programmers.stream()
                .flatMap(programmer -> programmer.getLanguages().stream())
                .collect(Collectors.toSet());
        System.out.println(StreamF);

        List<String> StreamG = programmers.stream()
                .filter(programmer -> programmer.getLanguages().size() > 2)
                .map(programmer -> programmer.getPerson().getLastName())
                .collect(Collectors.toList());

        Optional<Programmer> StreamH = programmers.stream()
                .filter(programmer -> programmer.getLanguages().isEmpty())
                .findAny();
        StreamH.ifPresent(System.out::println);

        int StreamI = (int) programmers.stream()
                .filter(programmer -> !programmer.getPerson().isMale())
                .flatMap(programmer -> programmer.getLanguages().stream())
                .distinct().count();
        System.out.println(StreamI);

        try (BufferedReader reader = new BufferedReader(new FileReader("plik.txt"))) {

//            Optional<String> najdluzszaLinia = reader.lines()
//                    .max((o1, o2) -> {
//                        return Integer.compare(o1.length(), o2.length());
//                    });

            Optional<String> najdluzszaLinia = reader.lines()
                    .max(Comparator.comparingInt(String::length));
            najdluzszaLinia.ifPresent(System.out::println);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
