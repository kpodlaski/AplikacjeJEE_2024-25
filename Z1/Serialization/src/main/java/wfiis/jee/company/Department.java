package wfiis.jee.company;

import java.util.List;

public class Department {
    private static int lastId;
    private int ID;
    private String name;

    public Department(){
        lastId++;
        ID = lastId;
    }
    public Department(String name, Person head, List<Person> members) {
        this();
        this.name = name;
        this.head = head;
        this.members = members;
    }

    private Person head;
    private List<Person> members;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getHead() {
        return head;
    }

    public void setHead(Person head) {
        this.head = head;
    }

    public List<Person> getMembers() {
        return members;
    }

    public void setMembers(List<Person> members) {
        this.members = members;
    }
}
