package com.example.psktask.persistence;

import com.example.psktask.entities.University;
import javax.transaction.Transactional;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class UniversityDAO implements BaseDAO<University, Long>{

    @Inject
    private EntityManager em;

    @Transactional
    public void create(University university) {
        em.persist(university);
    }

    @Override
    public University findById(Long id) {
        return em.find(University.class, id);
    }

    @Override
    public List<University> findAll() {
        return em.createQuery("SELECT c FROM University c", University.class).getResultList();
    }

    @Override
    public University save(University university) {
        return em.merge(university);
    }
    @Override
    public void deleteById(Long id) {
        University university = em.find(University.class, id);
        if (university != null) {
            em.remove(university);
        }
    }
}
