package model;

public class Person {
    private int id;
    private String name;
    private String surname;
    private Postition position;

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

    public Postition getPosition() {
        return position;
    }

    public void setPosition(Postition position) {
        this.position = position;
    }
}
