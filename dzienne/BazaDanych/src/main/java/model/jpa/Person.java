package model.jpa;

import jakarta.persistence.*;

import java.util.List;

@NamedQueries({
        @NamedQuery(name = "PersonGetAll", query = "Select p from Person as p"),
        @NamedQuery(name = "PersonByName", query = "Select p from Person as p where p.name=:name"),
        @NamedQuery(name = "PersonBySurname", query = "Select p from Person as p where p.surname=:surname"),
        @NamedQuery(name = "PersonByPartialName", query = "Select p from Person as p where p.name like concat('%',:name,'%')"),
        @NamedQuery(name = "PersonByPartialSurname", query = "Select p from Person as p where p.surname like concat('%',:surname,'%')"),
        @NamedQuery(name = "PersonByPositionName", query = "Select p from Person as p where p.position.name=:name  "),
        @NamedQuery(name = "PersonByPosition", query = "Select p from Person as p where p.position=:position  "),
        @NamedQuery(name = "PersonByUnitName", query = "Select u.members from Unit as u where u.name=:name"),
        @NamedQuery(name = "PersonDeleteById", query = "Delete Person as p where p.id=:id")
})
@Entity
@Table(name = "pracownik", schema = "public", catalog = "appdb")
public class Person extends model.Person {
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

    public Person(){}
    public Person(String name, String surname, Position position) {
        super();
        this.setName(name);
        this.setSurname(surname);
        this.setPosition(position);
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