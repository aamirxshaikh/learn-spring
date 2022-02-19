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

            Map<Course, Integer> map = new HashMap<>();
            Map<Course, Integer> map2 = new HashMap<>();

            map.put(new Course("Java", 999), 101);
            map.put(new Course("DSA", 999), 102);

            map2.put(new Course("React", 1999), 103);
            map2.put(new Course("AWS", 1999), 104);

            Student student = new Student("Aamir", map);
            Student student2 = new Student("John", map2);

            entityManager.persist(student);
            entityManager.persist(student2);

            for (Course course:map.keySet()) {
                entityManager.persist(course);
            }

            for (Course course:map2.keySet()) {
                entityManager.persist(course);
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.getTransaction().commit();

            entityManager.close();
            factory.close();
        }
    }
}
