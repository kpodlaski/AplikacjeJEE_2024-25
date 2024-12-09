package dao.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import model.Person;

import java.util.List;

public class PersonDAO implements dao.PersonDAO {

    private final EntityManager entityManager;
    private final DAO dao;

    public PersonDAO(EntityManager entityManager, DAO dao){
        this.entityManager = entityManager;
        this.dao = dao;
    }
    @Override
    public List<Person> getAllPersons() {
        Query q = entityManager.createNamedQuery("PersonGetAll");
        return q.getResultList();
    }

    @Override
    public List<Person> getPersonsByName(String name) {
        Query q = entityManager.createNamedQuery("PersonByName");
        q.setParameter("name",name);
        return q.getResultList();
    }

    @Override
    public List<Person> getPersonsBySurname(String surname) {
        Query q = entityManager.createNamedQuery("PersonBySurname");
        q.setParameter("surname",surname);
        return q.getResultList();
    }

    @Override
    public Person getPerson(int id) {
        return entityManager.find(model.jpa.Person.class,id);
    }

    @Override
    public int update(Person p) {
        dao.updateObject(p);
        return p.getId();
    }

    @Override
    public int insert(Person p) {
        dao.insertObject(p);
        return p.getId();
    }

    @Override
    public int delete(Person p) {
        return dao.remove(p);
    }

    @Override
    public int deletePerson(int id) {
        Query qn = entityManager.createNamedQuery("PersonDeleteById");
        qn.setParameter("id", id);
        return dao.updateQuery(qn);
    }

    @Override
    public void close() {
        dao.close();
    }
}
