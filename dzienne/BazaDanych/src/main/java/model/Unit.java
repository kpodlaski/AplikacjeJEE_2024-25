package model;

import java.util.ArrayList;
import java.util.List;

public class Unit {
    private int id;
    private String name;
    private List<Person> members = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<? extends Person> getMembers() {
        return members;
    }

    public void setMembers(List<? extends Person> members) {
        this.members = (List<Person>) members;
    }
}
