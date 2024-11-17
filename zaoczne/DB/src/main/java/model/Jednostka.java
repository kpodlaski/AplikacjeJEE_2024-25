package model;

import java.util.List;

public class Jednostka {
    private int id;
    private String nazwa;
    private List<Pracownik> pracownicy;

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

    public List<Pracownik> getPracownicy() {
        return pracownicy;
    }

    public void setPracownicy(List<Pracownik> pracownicy) {
        this.pracownicy = pracownicy;
    }

    @Override
    public String toString() {
        return "Jednostka{" +
                "id=" + id +
                ", nazwa='" + nazwa + '\'' +
                '}';
    }
}
