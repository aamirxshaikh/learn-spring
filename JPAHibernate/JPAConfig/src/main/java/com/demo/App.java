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

            Employee employee1 = new Employee("xyz", "abc", "Trainee", 49999D);
            Employee employee2 = new Employee("lmn", "opq", "Trainee", 59999D);

            entityManager.persist(employee1);
            entityManager.persist(employee2);

            Department department1 = new Department("IT", "abc");
            Department department2 = new Department("HR", "xyz");

            entityManager.persist(department1);
            entityManager.persist(department2);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.getTransaction().commit();

            entityManager.close();
            factory.close();
        }
    }
}
