import jakarta.persistence.*;

public class Main {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("car");
    EntityManager em = emf.createEntityManager();

    em.getTransaction().begin();
}
