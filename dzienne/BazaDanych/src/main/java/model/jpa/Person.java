package model.jpa;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "pracownik", schema = "public", catalog = "appdb")
public class Person {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "imie", nullable = true, length = -1)
    private String imie;
    @Basic
    @Column(name = "nazwisko", nullable = true, length = -1)
    private String nazwisko;
    @OneToOne
    @JoinColumn(name = "stanowisko", referencedColumnName = "id")
    private Position position;
    @ManyToMany(mappedBy = "personel")
    private List<Unit> units;

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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public List<Unit> getUnits() {
        return units;
    }

    public void setUnits(List<Unit> units) {
        this.units = units;
    }
}
