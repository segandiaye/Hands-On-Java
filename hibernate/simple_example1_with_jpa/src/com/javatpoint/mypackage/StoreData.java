package com.javatpoint.mypackage;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StoreData {
    public static void main(String[] args) {
        // Configure and open session
        SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Employee.class)
            .buildSessionFactory();

        Session session = factory.openSession();

        // Create employee
        Employee e = new Employee();
        e.setFirstName("Jean");
        e.setLastName("Dupont");

        // Save
        session.beginTransaction();
        session.save(e);
        session.getTransaction().commit();

        session.close();
        factory.close();

        System.out.println("Employee saved.");
    }
}

