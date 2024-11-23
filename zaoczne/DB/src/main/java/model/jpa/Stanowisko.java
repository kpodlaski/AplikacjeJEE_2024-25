package model.jpa;

import jakarta.persistence.*;

@Entity
public class Stanowisko {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "nazwa", nullable = true, length = -1)
    private String nazwa;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
}
