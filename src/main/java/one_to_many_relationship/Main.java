package one_to_many_relationship;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("car");
        EntityManager em = emf.createEntityManager();

        Driver driver = new Driver();
        driver.setName("eemeli");
        driver.setExperience(10);

        Car car1 = new Car();
        car1.setModel("bugatti");

        Car car2 = new Car();
        car2.setModel("audi");

        driver.addCar(car1);
        driver.addCar(car2);

        em.getTransaction().begin();

        em.persist(driver);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
