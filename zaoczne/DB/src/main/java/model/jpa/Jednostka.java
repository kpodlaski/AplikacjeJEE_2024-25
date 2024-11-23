package model.jpa;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Jednostka {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "nazwa", nullable = true, length = -1)
    private String nazwa;
    @ManyToMany
    @JoinTable(name = "pracjednlnk", catalog = "appdb", schema = "public", joinColumns = @JoinColumn(name = "id_jedn", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_prac", referencedColumnName = "id"))
    private List<Pracownik> pracownicy;

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

    public List<Pracownik> getPracownicy() {
        return pracownicy;
    }

    public void setPracownicy(List<Pracownik> pracownicy) {
        this.pracownicy = pracownicy;
    }
}
