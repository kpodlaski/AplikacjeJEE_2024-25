package model.jpa;

import jakarta.persistence.*;

import java.util.List;
@NamedQueries({
    @NamedQuery(name = "UnitGetAll", query = "Select u from Unit as u"),
    @NamedQuery(name="UnitByName",
        query="Select u from Unit as u where u.name=:name"),
    @NamedQuery(name="UnitByPartialName",
        query="Select u from Unit as u where u.name like concat('%',:name,'%')"),
    @NamedQuery(name="UnitByMemberName",
        query="Select p.units from Person as p where p.name=:name"),
    @NamedQuery(name="UnitByMemberSurname",
        query="Select p.units from Person as p where p.surname=:surname")
}
)
@Entity
@Table(name = "jednostka", schema = "public", catalog = "appdb")
public class Unit extends model.Unit {
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

    public List<Person > getMembers() {
        return members;
    }

    public void setMembers(List<? extends model.Person> personel) {
        this.members = (List<Person>) personel;
    }
}
