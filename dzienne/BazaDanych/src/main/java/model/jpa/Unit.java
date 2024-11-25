package model.jpa;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "jednostka", schema = "public", catalog = "appdb")
public class Unit  {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "un_seq_gen")
    @SequenceGenerator(name = "un_seq_gen", sequenceName = "seq_id_jednostka", allocationSize = 1)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "nazwa", nullable = true, length = -1)
    private String name;
    @ManyToMany
    @JoinTable(name = "pracjednlnk", catalog = "appdb", schema = "public", joinColumns = @JoinColumn(name = "id_jedn", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_prac", referencedColumnName = "id"))
    private List<Person> members;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String nazwa) {
        this.name = nazwa;
    }

    public List<Person> getMembers() {
        return members;
    }

    public void setMembers(List<Person> personel) {
        this.members = personel;
    }
}
