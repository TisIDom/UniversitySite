package com.example.psktask.persistence;

import com.example.psktask.entities.Course;
import com.example.psktask.entities.Student;

import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@ApplicationScoped
public class StudentDAO implements BaseDAO<Student, Long>{

    @PersistenceContext
    private EntityManager em;

    public void create(Student student) {
        em.persist(student);
    }

    @Override
    public Student findById(Long id) {
        return em.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        return em.createQuery("SELECT c FROM Student c", Student.class).getResultList();
    }

    @Override
    public Student save(Student student) {
        return em.merge(student);
    }
    @Override
    public void deleteById(Long id) {
        Student student = em.find(Student.class, id);
        if (student != null) {
            em.remove(student);
        }
    }
}
