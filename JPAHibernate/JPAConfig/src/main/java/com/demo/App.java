package com.demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("EmployeeDBUnit");
        EntityManager entityManager = factory.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            Department department1 = new Department("IT", "abc");
            Department department2 = new Department("HR", "xyz");

            Account account1 = new Account("xyz@test.com", "password");
            Account account2 = new Account("lmn@test.com", "password");
            Account account3 = new Account("pqr@test.com", "password");

            Employee employee1 = new Employee("xyz", "abc", "Trainee", 49999D);
            Employee employee2 = new Employee("lmn", "opq", "Trainee", 59999D);
            Employee employee3 = new Employee("pqr", "sf", "Trainee", 59999D);

            Project project1 = new Project("Automation", "IT", LocalDate.of(2022, 3, 10));
            Project project2 = new Project("ChatBot", "IT", LocalDate.of(2023, 3, 10));

            employee1.setAccount(account1);
            employee2.setAccount(account2);
            employee3.setAccount(account3);

            employee1.setDepartment(department1);
            employee2.setDepartment(department2);
            employee3.setDepartment(department1);

            employee1.addProject(project1);
            employee1.addProject(project2);
            employee2.addProject(project1);
            employee3.addProject(project2);

//            create

            entityManager.persist(project1);
            entityManager.persist(project2);

            entityManager.persist(department1);
            entityManager.persist(department2);

            entityManager.persist(employee1);
            entityManager.persist(employee2);
            entityManager.persist(employee3);

            entityManager.persist(account1);
            entityManager.persist(account2);
            entityManager.persist(account3);

//            select

            System.out.println("Employee 1 " + entityManager.find(Employee.class, 1L));
            System.out.println("Employee 2 " + entityManager.find(Employee.class, 2L));

//            select all

            List<Employee> employees = entityManager.createQuery("SELECT e FROM Employee e").getResultList();

            System.out.println("All Employees");

            for (Employee employee : employees) {
                System.out.println(employee);
            }

            List<Account> accounts = entityManager.createQuery("SELECT ea FROM Account ea").getResultList();

            System.out.println("All Employee Accounts");

            for (Account account : accounts) {
                System.out.println(account);
            }

            List<Department> departments = entityManager.createQuery("SELECT d FROM Department d").getResultList();

            System.out.println("All Departments");

            for (Department department : departments) {
                System.out.println(department);
            }

            List<Project> projects = entityManager.createQuery("SELECT p FROM Project p").getResultList();

            System.out.println("All Projects");

            for (Project project : projects) {
                System.out.println(project);
            }

//            update

            entityManager.find(Employee.class, 1L).setFirstName("XYZ");

//            delete

//            entityManager.remove(entityManager.find(Employee.class, 1L));

            EmployeeCheckin checkin1 = new EmployeeCheckin(1, LocalDate.now(), LocalTime.now());
            EmployeeCheckin checkin2 = new EmployeeCheckin(1, LocalDate.now().plusDays(1), LocalTime.now());

            System.out.println(checkin1.toString());
            System.out.println(checkin2.toString());

            entityManager.persist(checkin1);
            entityManager.persist(checkin2);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.getTransaction().commit();

            entityManager.close();
            factory.close();
        }
    }
}
