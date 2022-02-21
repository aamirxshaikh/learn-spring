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
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("InheritedClassesDBUnit");

        EntityManager entityManager = factory.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            FullTimeEmployee aamir = new FullTimeEmployee("Aamir", 99999);
            FullTimeEmployee jane = new FullTimeEmployee("Jane", 88888);

            ContractEmployee john = new ContractEmployee("John", 19999);
            ContractEmployee jim = new ContractEmployee("Jim", 28999);

            Department it = new Department("IT");
            it.addEmployee(aamir);
            it.addEmployee(jane);

            Vendor admin = new Vendor("Admin");
            admin.addEmployee(john);
            admin.addEmployee(jim);

            entityManager.persist(it);
            entityManager.persist(admin);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.getTransaction().commit();

            entityManager.close();
            factory.close();
        }
    }
}
