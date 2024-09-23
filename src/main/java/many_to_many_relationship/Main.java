package many_to_many_relationship;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("car");
        EntityManager em = emf.createEntityManager();
        Driver driver1 = new Driver();
        driver1.setName("Amir");
        driver1.setExperience(3);
        Driver driver2 = new Driver();
        driver2.setName("Simo");
        driver2.setExperience(5);
        Car car1 = new Car();
        car1.setModel("Lada Niva");
        Car car2 = new Car();
        car2.setModel("Toyota Corolla");
        driver1.addCar(car1);
        driver1.addCar(car2);
        driver2.addCar(car1);
        em.getTransaction().begin();
        em.persist(driver1);
        em.persist(driver2);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
