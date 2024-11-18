package model.jpa;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "jednostka", schema = "public", catalog = "appdb")
public class Unit {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "nazwa", nullable = true, length = -1)
    private String nazwa;
    @ManyToMany
    @JoinTable(name = "pracjednlnk", catalog = "appdb", schema = "public", joinColumns = @JoinColumn(name = "id_jedn", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_prac", referencedColumnName = "id"))
    private List<Person> personel;

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

    public List<Person> getPersonel() {
        return personel;
    }

    public void setPersonel(List<Person> personel) {
        this.personel = personel;
    }
}
