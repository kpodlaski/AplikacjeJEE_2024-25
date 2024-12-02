import dao.DAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import model.jpa.Person;
import model.jpa.Position;
import model.jpa.Unit;

import java.util.ArrayList;
import java.util.List;

public class SimpleJPAExample {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("appdb");
        EntityManager em = emf.createEntityManager();
        Query nq = em.createNamedQuery("PositionByName");
        nq.setParameter("name","kierownik");
        for(Position pos :  (List<Position>) nq.getResultList()){
            System.out.println(pos.getId() + " " + pos.getName());
        }
        nq = em.createNamedQuery("PositionByPartialName");
        nq.setParameter("name","r");
        for(Position pos :  (List<Position>) nq.getResultList()){
            System.out.println(pos.getId() + " " + pos.getName());
        }
        nq = em.createNamedQuery("UnitByMemberName");
        nq.setParameter("name","Adam");
        nq.getResultList();

        DAO dao = new dao.jpa.DAO(em);
        dao.getAllPersons();
        dao.getPerson(3);
        dao.getPersonsByName("Adam");
        dao.getPersonsBySurname("kTOŚ");
        dao.getPosition(1);
        dao.getAllPositions();
        dao.getPositionByName("PMAGIER");
        Position p = new Position("IT Admin");
        dao.insert(p);
        Person person = new Person("Janina","Janicka",p);
        dao.insert(person);
        p.setName("Admin IT");
        dao.update(p);
        person.setSurname("Noname");
        dao.update(person);
        em.close();
        emf.close();

    }
    public static void main2(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("appdb");
        EntityManager em = emf.createEntityManager();
        Position position = em.find(Position.class, 1);
        System.out.println(position.getName() +" "+position.getId());
        Person p = em.find(Person.class, 3);
        System.out.println(p.getId() + " "+p.getSurname());
        for( Unit j : p.getUnits()){
            System.out.println(j.getName());
            System.out.println(j.getMembers());
        }
        Position pos = new Position();
        pos.setName("developer");
        System.out.println(pos);
        em.getTransaction().begin();
        em.persist(pos);
        //pos = em.merge(pos);
        em.getTransaction().commit();
        System.out.println(pos);
        Person p1 = new Person();
        p1.setName("Halina");
        p1.setSurname("Łódzka");
        p1.setPosition(pos);
        Unit j = em.find(Unit.class,1);
        List<Unit> jedn = new ArrayList<>();
        jedn.add(j);
        p1.setUnits(jedn);
        j.getMembers().add(p1);
        em.getTransaction().begin();
        em.persist(p1);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
