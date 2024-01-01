package ru.Buro;

import com.google.gson.Gson;
import ru.Buro.Domain.Person;

/**
 * Используйте библиотеку gson для сериализации
 * и десериализации объектов класса Person в формат JSON
 */
public class App {
    public static void main(String[] args) {
        Person Sam = new Person("Sam", "Fisher", 25);
        System.out.println(Sam);
        Person Nick = new Person("Nick", "SabJur", 23);
        System.out.println(Nick);
        Person Sam1 = new Person("Sam", "Fisher", 25);
        System.out.println(Sam1);
        Person Sam2 = new Person("Sam", "Fisher", 30);
        System.out.println("Sam1 is equals Sam? It is " + Sam1.equals(Sam));
        System.out.println("Sam2 is equals Sam? It is " + Sam2.equals(Sam));
        System.out.println("Nick is equals Sam? It is " + Nick.equals(Sam));
        System.out.println(Sam.hashCode());
        System.out.println(Sam1.hashCode());
        System.out.println(Sam2.hashCode());
        System.out.println(Nick.hashCode());

        Gson gson = new Gson();
        String jsonSam1 = gson.toJson(Sam1);
        System.out.println(jsonSam1);
        Person read = gson.fromJson(jsonSam1, Person.class);
        System.out.println(read);
    }
}
