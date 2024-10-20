package wfiis.jee.company;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Company {

    public static void main(String[] args) {
        //serialization();
        deserialization();
    }

    private static void deserialization() {
        Department d;
        ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        try {
            d = mapper.readValue(new File("dep.json"),Department.class);
            System.out.println(d.getName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    static void serialization(){
        Person p = new Person("Jan", "Potocki", Function.WORKER);
        ArrayList<Person> members = new ArrayList<>();
        members.add(p);
        members.add(new Person("Janina", "Rzepecka", Function.DEP_HEAD));
        p = new Person("Janusz", "Kopytko", Function.IT_SPEC);
        members.add(p);
        members.add(new Person("Karolina", "Gazda", Function.OFFICER));
        Department department = new Department("Filia w Gdańsku",p,members);

        ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        try {
            String json = mapper.writeValueAsString(department);
            System.out.println(json);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        try {
            mapper.writeValue(new File("dep.json"), department);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
