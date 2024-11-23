import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.jpa.Stanowisko;
import model.jpa.Pracownik;

public class JPAIntro {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("appdb");
        EntityManager em = emf.createEntityManager();
        Stanowisko st = em.find(Stanowisko.class, 2);
        System.out.println(st.getNazwa());
        Pracownik p = em.find(Pracownik.class,3);
        System.out.println(p.getImie());
        System.out.println(p.getStanowisko().getNazwa());
    }
}
