package com.demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class App
{
    public static void main( String[] args )
    {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("EmployeeDBUnit");
        EntityManager entityManager = factory.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            Employee employee1 = new Employee(2000, "xyz", "abc", "Trainee", 49999D);
            Employee employee2 = new Employee(2001, "lmn", "opq", "Trainee", 59999D);
            Employee employee3 = new Employee();

            employee3.setId(1);

            entityManager.persist(employee1);
            entityManager.persist(employee2);
            entityManager.persist(employee3);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.getTransaction().commit();

            entityManager.close();
            factory.close();
        }
    }
}
