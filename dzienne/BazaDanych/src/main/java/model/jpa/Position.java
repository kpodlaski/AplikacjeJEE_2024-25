package model.jpa;

import jakarta.persistence.*;

import java.util.List;
@NamedQueries({
        @NamedQuery(name = "PositionGetAll", query = "Select pos from Position as pos"),
        @NamedQuery(name="PositionByName",
                query="Select pos from Position as pos where pos.name=:name"),
        @NamedQuery(name="PositionByPartialName",
                query="Select pos from Position as pos where pos.name like concat('%',:name,'%')"),
        @NamedQuery(name="PositionDeleteById", query="Delete Position pos where id=:id")
}
)
@Entity
@Table(name = "stanowisko", schema = "public", catalog = "appdb")
public class Position extends model.Position {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pos_seq_gen")
    @SequenceGenerator(name = "pos_seq_gen", sequenceName = "seq_id_stanowisko", allocationSize = 1)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "nazwa", nullable = true, length = -1)
    private String name;

    public Position(){

    }
    public Position(String name) {
        super();
        setName(name);
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

    public void setName(String nazwa) {
        this.name = nazwa;
    }

}
