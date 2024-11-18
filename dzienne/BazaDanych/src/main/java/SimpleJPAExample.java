import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.jpa.Person;
import model.jpa.Position;
import model.jpa.Unit;

import java.util.ArrayList;
import java.util.List;

public class SimpleJPAExample {

    public static void main(String[] args) {
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
