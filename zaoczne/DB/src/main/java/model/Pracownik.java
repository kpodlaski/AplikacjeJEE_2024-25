package model;

import java.util.List;

public class Pracownik {
    private int id;
    private String imie;
    private String nazwisko;
    private Stanowisko stanowisko;
    private List<Jednostka> jednostki;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public Stanowisko getStanowisko() {
        return stanowisko;
    }

    public void setStanowisko(Stanowisko stanowisko) {
        this.stanowisko = stanowisko;
    }

    public List<Jednostka> getJednostki() {
        return jednostki;
    }

    public void setJednostki(List<Jednostka> jednostki) {
        this.jednostki = jednostki;
    }

    @Override
    public String toString() {
        return "Pracownik{" +
                "id=" + id +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", stanowisko=" + stanowisko +
                '}';
    }
}
