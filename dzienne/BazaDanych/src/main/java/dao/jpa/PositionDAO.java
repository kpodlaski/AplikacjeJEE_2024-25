package dao.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import model.Position;

import java.util.List;

public class PositionDAO implements dao.PositionDAO{

    private final EntityManager entityManager;
    private final DAO dao;

    public PositionDAO(EntityManager entityManager, DAO dao){
        this.entityManager = entityManager;
        this.dao = dao;
    }

    @Override
    public List<Position> getAllPositions() {
        Query qn = entityManager.createNamedQuery("PositionGetAll");
        return (List<Position>) qn.getResultList();
    }

    @Override
    public Position getPosition(int id) {
        return entityManager.find(model.jpa.Position.class, id);
    }

    @Override
    public List<Position> getPositionByName(String name) {
        Query qn = entityManager.createNamedQuery("PositionByName");
        qn.setParameter("name", name);
        return (List<Position> ) qn.getResultList();
    }

    @Override
    public int update(Position p) {
        dao.updateObject(p);
        return p.getId();
    }

    @Override
    public int insert(Position p) {
        dao.insertObject(p);
        return p.getId();
    }

    @Override
    public int delete(Position p) {
        return dao.remove(p);
    }

    @Override
    public int deletePosition(int id) {
        Query qn = entityManager.createNamedQuery("PositionDeleteById");
        qn.setParameter("id",id);
        return dao.updateQuery(qn);
    }

    @Override
    public void close() {
        dao.close();
    }
}
