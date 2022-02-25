package com.demo;

import javax.persistence.*;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    @SuppressWarnings("unchecked")
    public static void main( String[] args )
    {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("QueriesDBUnit");

        EntityManager entityManager = factory.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            Query normalJpqlQuery = entityManager.createQuery("SELECT c FROM Categories c");
            TypedQuery<Category> typedQuery = entityManager.createQuery("SELECT c FROM Categories c", Category.class);

            typedQuery.setFirstResult(0);
            typedQuery.setMaxResults(3);

            System.out.println(typedQuery.getFirstResult());
            System.out.println(typedQuery.getMaxResults());

            List<Category> normalJpqlQueryCategories = (List<Category>) normalJpqlQuery.getResultList();
            List<Category> typedQueryCategories = typedQuery.getResultList();

            System.out.println(normalJpqlQueryCategories);
            System.out.println(typedQueryCategories);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.getTransaction().commit();

            entityManager.close();
            factory.close();
        }
    }
}
