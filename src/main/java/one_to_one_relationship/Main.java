package one_to_one_relationship;

import jakarta.persistence.*;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("car");
        EntityManager em = emf.createEntityManager();

        DriverOneToOne driverOneToOne = new DriverOneToOne();
        driverOneToOne.setName("Jokuman");
        driverOneToOne.setExperience(5);

        CarOneToOne carOneToOne = new CarOneToOne();
        carOneToOne.setModel("Tesla");

        carOneToOne.setDriver(driverOneToOne);
        driverOneToOne.setCar(carOneToOne);

        em.getTransaction().begin();

        em.persist(driverOneToOne);
        em.persist(carOneToOne);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
