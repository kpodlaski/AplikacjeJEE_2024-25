package model.jpa;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "pracownik", schema = "public", catalog = "appdb")
public class Person {
    @SequenceGenerator(name = "seq_gen_person", sequenceName = "seq_id_pracownik", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_gen_person")
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "imie", nullable = true, length = -1)
    private String name;
    @Basic
    @Column(name = "nazwisko", nullable = true, length = -1)
    private String surname;
    @OneToOne
    @JoinColumn(name = "stanowisko", referencedColumnName = "id")
    private Position position;
    @ManyToMany(mappedBy = "members")
    private List<Unit> units;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String imie) {
        this.name = imie;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String nazwisko) {
        this.surname = nazwisko;
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