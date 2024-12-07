import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import model.jpa.Jednostka;
import model.jpa.Stanowisko;
import model.jpa.Pracownik;

import java.util.ArrayList;
import java.util.List;

public class JPAIntro {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("appdb");
        EntityManager em = emf.createEntityManager();
        Stanowisko st = em.find(Stanowisko.class, 2);
        System.out.println(st.getNazwa());
        Pracownik p = em.find(Pracownik.class,3);
        System.out.println(p.getImie());
        System.out.println(p.getStanowisko().getNazwa());
        for (Jednostka j : p.getJednostki() ){
            System.out.println(j.getNazwa());
        }
        Stanowisko s2 = new Stanowisko();
        s2.setId(25);
        s2.setNazwa("IT Admin");
        em.getTransaction().begin();
        em.persist(s2);
        //Stanowisko st3 = em.merge(s2);
        em.getTransaction().commit();
        System.out.println(s2);
        //System.out.println(st3);
        em.getTransaction().begin();
        st.setNazwa("ITT Admin");

        //em.flush(s2); //s2);
        em.getTransaction().commit();
        Jednostka j = new Jednostka();
        j.setId(5);
        j.setNazwa("IT");
        j.setPracownicy(new ArrayList<>());
        j.getPracownicy().add(p);
        Pracownik p2 = new Pracownik();
        p2.setId(12);
        p2.setImie("ABC");
        p2.setNazwisko("CBA");
        p2.setStanowisko(st);
        j.getPracownicy().add(p2);
        em.getTransaction().begin();
        em.persist(p2);
        em.persist(j);
        em.getTransaction().commit();

        Query q = em.createNamedQuery("Stanowisko.GetByNazwa");
        q.setParameter("nazwa","kierownik");
        List<Stanowisko> stanowiskoList =  q.getResultList();
        for (Stanowisko s : stanowiskoList){
            System.out.println(s.getNazwa());
        }

        q = em.createNamedQuery("Stanowisko.GetNazwaLike");
        q.setParameter("nazwa","e");
        stanowiskoList =  q.getResultList();
        for (Stanowisko s : stanowiskoList){
            System.out.println(s.getNazwa());
        }
    }
}
