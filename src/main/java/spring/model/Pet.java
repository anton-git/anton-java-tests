package spring.model;

import lombok.Data;

@Data
public class Pet {

    private String name;
    private String type;

    private int age;
    private Person owner;



}
