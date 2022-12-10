package pl.sda.j133.streams.postawy.homework;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {

    private String firstName;
    private String lastName;
    private int age;
    private boolean male;
}
