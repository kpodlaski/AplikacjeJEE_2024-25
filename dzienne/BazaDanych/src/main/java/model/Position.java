package model;

public class Position {
    private int id;
    private String name;

    public Position(){
        name="";
    }
    public Position(int id, String nazwa) {
        this.id = id;
        this.name = nazwa;
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
}
