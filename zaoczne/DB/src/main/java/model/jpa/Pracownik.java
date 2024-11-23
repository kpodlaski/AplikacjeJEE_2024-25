package model.jpa;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Pracownik {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "imie", nullable = true, length = -1)
    private String imie;
    @Basic
    @Column(name = "nazwisko", nullable = true, length = -1)
    private String nazwisko;
    @OneToOne
    @JoinColumn(name = "stanowisko", referencedColumnName = "id")
    private Stanowisko stanowisko;
    @ManyToMany(mappedBy = "pracownicy")
    private List<Jednostka> jednostki;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
}
