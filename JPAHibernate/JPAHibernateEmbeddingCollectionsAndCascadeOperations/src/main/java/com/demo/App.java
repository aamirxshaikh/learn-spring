package com.demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("CollectionsDBUnit");

        EntityManager entityManager = factory.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            Set<Course> set = new HashSet<>();
            Set<Course> set2 = new HashSet<>();

            set.add(new Course("React"));
            set.add(new Course("Vue"));

            set2.add(new Course("Spring boot"));
            set2.add(new Course("Spring boot microservices"));

            Student student = new Student("Aamir", set);
            Student student2 = new Student("John", set2);

            entityManager.persist(student);
            entityManager.persist(student2);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.getTransaction().commit();

            entityManager.close();
            factory.close();
        }
    }
}
