package dao.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import model.Person;
import model.Position;

import java.sql.SQLException;
import java.util.List;

public class DAO implements dao.DAO{
    private final EntityManager entityManager;
    private PersonDAO personDAO;
    private PositionDAO positionDAO;

    public DAO(){
        EntityManagerFactory emf =  Persistence.createEntityManagerFactory("appdb");
        this.entityManager = emf.createEntityManager();
        personDAO = new PersonDAO(this.entityManager,this);
        positionDAO = new PositionDAO(this.entityManager, this);
    }
    public DAO(EntityManager entityManager){
        this.entityManager = entityManager;
        personDAO = new PersonDAO(this.entityManager,this);
        positionDAO = new PositionDAO(this.entityManager, this);
    }

    @Override
    public List<Position> getAllPositions() {
        return positionDAO.getAllPositions();
    }

    @Override
    public Position getPosition(int id) {
        return positionDAO.getPosition(id);
    }

    @Override
    public List<Position> getPositionByName(String name) {
        return positionDAO.getPositionByName(name);
    }

    @Override
    public int update(Position p) {
        return positionDAO.update(p);
    }

    @Override
    public int insert(Position p) {
        return positionDAO.insert(p);
    }

    @Override
    public int delete(Position p) {
        return positionDAO.delete(p);
    }

    @Override
    public int deletePosition(int id) {
        return positionDAO.deletePosition(id);
    }

    @Override
    public List<Person> getAllPersons() {
        return personDAO.getAllPersons();
    }

    @Override
    public List<Person> getPersonsByName(String name) {
        return personDAO.getPersonsByName(name);
    }

    @Override
    public List<Person> getPersonsBySurname(String surname) {
        return personDAO.getPersonsBySurname(surname);
    }

    @Override
    public Person getPerson(int id) {
        return personDAO.getPerson(id);
    }

    @Override
    public int update(Person p) {
        return personDAO.update(p);
    }

    @Override
    public int insert(Person p) {
        return personDAO.insert(p);
    }

    @Override
    public int delete(Person p) {
        return personDAO.delete(p);
    }

    @Override
    public int deletePerson(int id) {
        return personDAO.deletePerson(id);
    }

    @Override
    public void close() {
        this.entityManager.close();
    }

    void updateObject(Object entity){
        entityManager.getTransaction().begin();
        entityManager.flush();
        entityManager.getTransaction().commit();
    }

    void insertObject(Object entity){
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    int updateQuery(Query q){
        entityManager.getTransaction().begin();
        int i = q.executeUpdate();
        entityManager.getTransaction().commit();
        return i;
    }

    int remove(Object o) {
        entityManager.getTransaction().begin();
        entityManager.remove(o);
        entityManager.getTransaction().commit();
        return 1;
    }

}
