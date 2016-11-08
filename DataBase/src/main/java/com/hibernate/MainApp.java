package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

import static javafx.scene.input.KeyCode.Q;

public class MainApp {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure()
                .buildSessionFactory();

        Session session = sessionFactory.openSession();

        Transaction transaction = session.beginTransaction();

        /*
        Student student = new Student();
        student.setFname("Vadya");
        student.setLname("Volk");
        student.setAge(22);

        session.save(student);
        */

        Query query = session.createQuery("from Student");
        List<Student> students = query.getResultList();

        transaction.commit();

        session.close();
        System.out.println(students);
    }
}
