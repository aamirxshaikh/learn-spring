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

        entityManager.getTransaction().begin();

        Employee employee1 = new Employee(200, "xyz", "abc", "Trainee", 49999);
        Employee employee2 = new Employee(201, "lmn", "opq", "Trainee", 59999);

        entityManager.persist(employee1);
        entityManager.persist(employee2);

        entityManager.getTransaction().commit();

        entityManager.close();
        factory.close();
    }
}
