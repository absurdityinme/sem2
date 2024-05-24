package org.example.reflexion;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class MainParse {
    public static void main(String[] args) throws IOException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        Person person = new Person();
        ParseJson parseJson = new ParseJson(person, new File("test.json"));
        person = (Person) parseJson.read();
        System.out.println("Surname: " + person.getSurname() + "\nName: " + person.getName() + "\nAge: " + person.getAge());
    }
}
