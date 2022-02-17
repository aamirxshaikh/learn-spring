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

            Map<Integer, Course> map = new HashMap<>();
            Map<Integer, Course> map2 = new HashMap<>();

            map.put(101, new Course("Java", 999));
            map.put(102, new Course("DSA", 999));

            map2.put(103, new Course("React", 1999));
            map2.put(104, new Course("AWS", 1999));

            Student student = new Student("Aamir", map);
            Student student2 = new Student("John", map2);

            entityManager.persist(student);
            entityManager.persist(student2);

            for (Course course:map.values()) {
                entityManager.persist(course);
            }

            for (Course course:map2.values()) {
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
