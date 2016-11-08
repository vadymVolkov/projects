package com.smartschool.rest.repository;


import com.smartschool.rest.model.Student;
import javafx.scene.Parent;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import java.util.List;

@Repository
public class StudentRepository {
    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    EntityManager entityManager;

    public List<Student> getStudents() {
        Query query = entityManager.createQuery("from Student");
        return query.getResultList();
    }
    public List<Student> getStudentsByClassId(int id) {
        Query query = entityManager.createQuery("from Student s where s.class_id = :id");
        query.setParameter("id", id);

        List<Student> students = query.getResultList();

        return students;
    }

    public List<Parent> getParentOfStudentsByClassId(int id) {
        Query query = entityManager.createQuery("select new Parent from Student s, Parent p where s.class_id = :id");
        query.setParameter("id", id);

        List<Student> students = query.getResultList();

        return students;
    }

}
