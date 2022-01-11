package com.demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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

        entityManager.getTransaction().begin();

        Car car1 = new Car(1, "BMW", "x5");

        entityManager.persist(car1);

        entityManager.getTransaction().commit();

        entityManager.close();
        factory.close();
    }
}
