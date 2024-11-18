package model.jpa;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "stanowisko", schema = "public", catalog = "appdb")
public class Position {
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "nazwa", nullable = true, length = -1)
    private String name;

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

}
