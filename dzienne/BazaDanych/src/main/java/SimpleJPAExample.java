import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.jpa.Position;

public class SimpleJPAExample {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("appdb");
        EntityManager em = emf.createEntityManager();
        Position position = em.find(Position.class, 1);
        System.out.println(position.getNazwa() +" "+position.getId());
        em.close();
        emf.close();
    }
}
