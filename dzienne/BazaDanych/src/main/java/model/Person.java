package model;

public class Person {
    private int id;
    private String name;
    private String surname;
    private Position position;

    public Person(){
        name="";
        surname="";
        position = null;
    }
    public Person(int id, String name, String surname, Position position) {
        this.id=id;
        this.name = name;
        this.surname = surname;
        this.position = position;
    }

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
