package com.demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.GregorianCalendar;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("CarDB_Unit");

        EntityManager entityManager = factory.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            Car car1 = new Car("BMW", "x5");
            Car car2 = new Car();

            entityManager.persist(car1);
            entityManager.persist(car2);

            Owner owner1 = new Owner("Aamir", new GregorianCalendar(2000, 1, 3).getTime());
            Owner owner2 = new Owner("Xyz", new GregorianCalendar(2000, 2, 3).getTime());

            entityManager.persist(owner1);
            entityManager.persist(owner2);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.getTransaction().commit();

            entityManager.close();
            factory.close();
        }
    }
}
