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
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("CascadeDBUnit");

        EntityManager entityManager = factory.createEntityManager();

        try {
            entityManager.getTransaction().begin();

//            Employee aamir = new Employee("Aamir");
//            Employee john = new Employee("John");
//            Employee jane = new Employee("Jane");
//            Employee mark = new Employee("Mark");
//
//            Department it = new Department("IT");
//            Department hr = new Department("HR");

//            it.addEmployee(aamir);
//            it.addEmployee(john);
//
//            hr.addEmployee(jane);
//            hr.addEmployee(mark);
//
//            entityManager.persist(it);
//            entityManager.persist(hr);

            Employee jim = new Employee("Jim");

            Department hr = entityManager.find(Department.class, 2);

            hr.addEmployee(jim);

            entityManager.merge(hr);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.getTransaction().commit();

            entityManager.close();
            factory.close();
        }
    }
}
