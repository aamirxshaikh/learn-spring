package com.demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.*;

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

            Map<Integer, String> map = new HashMap<>();
            Map<Integer, String> map2 = new HashMap<>();

            map.put(1, "Java");
            map.put(2, "DSA");

            map2.put(3, "React");
            map2.put(4, "AWS");

            Student student = new Student("Aamir", map);
            Student student2 = new Student("John", map2);

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
