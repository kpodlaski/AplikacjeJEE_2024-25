package model;

public class Stanowisko {
    private int id;
    private String nazwa;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @Override
    public String toString() {
        return "Stanowisko{" +
                "id=" + id +
                ", nazwa='" + nazwa + '\'' +
                '}';
    }
}
