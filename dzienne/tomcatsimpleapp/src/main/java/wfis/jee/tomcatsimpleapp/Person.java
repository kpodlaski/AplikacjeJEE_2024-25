package wfis.jee.tomcatsimpleapp;

public class Person {

    private static int lastId;
    private int ID;
    private String name;
    private String surname;
    private Function function;

    public Person(){
        lastId++;
        ID = lastId;
        name = "John";
        surname = "Doe";
        function = null;
    }

    public Person(String name, String surname, Function function) {
        this();
        this.name = name;
        this.surname = surname;
        this.function = function;
    }

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Function getFunction() {
        return function;
    }

    public void setFunction(Function function) {
        this.function = function;
    }
}
