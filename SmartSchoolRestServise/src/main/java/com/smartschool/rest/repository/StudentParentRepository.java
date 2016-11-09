package com.smartschool.rest.repository;

import com.smartschool.rest.model.Student;
import com.smartschool.rest.model.StudentParent;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import java.util.List;

@Repository
public class StudentParentRepository {
    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    EntityManager entityManager;

    public List<StudentParent> getParentByClassId(int id) {
        Query query = entityManager.createQuery("select p.parent_fname, p.parent_lname, p.parent_mobnum from StudentParent p inner join Student s on s.parent_id = p.parent_id where s.class_id = :id");
        query.setParameter("id", id);

        List<StudentParent> studentParents = query.getResultList();

        return studentParents;
    }
}
