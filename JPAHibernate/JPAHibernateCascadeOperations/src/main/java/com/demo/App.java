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

//            persist

//            entityManager.persist(it);
//            entityManager.persist(hr);

//            remove

//            entityManager.remove(entityManager.find(Department.class, 1));

//            merge

//            Employee jim = new Employee("Jim");
//
//            Department hr = entityManager.find(Department.class, 2);
//
//            hr.addEmployee(jim);
//
//            entityManager.merge(hr);

//            detach

            Department it = entityManager.find(Department.class, 1);

            Employee aamir = entityManager.find(Employee.class, 2);
            Employee mark = entityManager.find(Employee.class, 3);

            entityManager.detach(it);

            System.out.println("Is IT detached " + entityManager.contains(it));
            System.out.println("Is aamir detached " + entityManager.contains(aamir));
            System.out.println("Is mark detached " + entityManager.contains(mark));
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.getTransaction().commit();

            entityManager.close();
            factory.close();
        }
    }
}
