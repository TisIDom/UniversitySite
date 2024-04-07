package com.example.psktask.persistence;

import com.example.psktask.entities.Course;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class CourseDAO implements BaseDAO<Course, Long>{

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void create(Course course) {
        em.persist(course);
    }

    @Override
    public Course findById(Long id) {
        return em.find(Course.class, id);
    }

    @Override
    public List<Course> findAll() {
        return em.createQuery("SELECT c FROM Course c", Course.class).getResultList();
    }

    @Override
    public Course save(Course course) {
        return em.merge(course);
    }
    @Override
    public void deleteById(Long id) {
        Course course = em.find(Course.class, id);
        if (course != null) {
            em.remove(course);
        }
    }
}


//package com.example.psktask.persistence;
//
//import com.example.psktask.entities.Student;
//import com.example.psktask.entities.University;
//import com.example.psktask.entities.Course;
//import com.example.psktask.mybatis.dao.CourseMapper;
//import org.apache.ibatis.io.Resources;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.ibatis.session.SqlSessionFactoryBuilder;
//
//import javax.enterprise.context.ApplicationScoped;
//import javax.inject.Inject;
//import javax.persistence.Basic;
//import javax.persistence.ManyToMany;
//import javax.persistence.ManyToOne;
//import javax.transaction.Transactional;
//import java.io.IOException;
//import java.util.List;
//
//@ApplicationScoped
//public class CourseDAO implements CourseMapper{
//    @Inject
//    private SqlSessionFactory sqlSessionFactory;
//
//    @Inject
//    private UniversityDAO universityDAO;
//    @Override
//    public int deleteById(Long id) {
//        try (SqlSession session = sqlSessionFactory.openSession()) {
//            return session.delete("com.example.psktask.mybatis.dao.CourseMapper.deleteById", id);
//        }
//    }
//
//    @Transactional
//    @Override
//    public int create(Course course) {
//        try (SqlSession session = sqlSessionFactory.openSession()) {
//            return session.insert("com.example.psktask.mybatis.dao.CourseMapper.create", course);
//        }
//    }
//    @Override
//    public Course findById(Long id) {
//        Course model;
//        try (SqlSession session = sqlSessionFactory.openSession()) {
//            return session.selectOne("com.example.psktask.mybatis.dao.CourseMapper.findById", id);
//        }
//        //return convertModelToEntity(model);
//    }
//
//    @Override
//    public List<Course> findAll() {
//        try (SqlSession session = sqlSessionFactory.openSession()) {
//            return session.selectList("com.example.psktask.mybatis.dao.CourseMapper.findAll");
//        }
//    }
//
//    @Transactional
//    @Override
//    public int save(Course course) {
//        int rowsAffected;
//        try (SqlSession session = sqlSessionFactory.openSession()) {
//            if (course.getId() != null) {
//                rowsAffected = session.update("com.example.psktask.mybatis.dao.CourseMapper.save", course);
//            } else {
//                rowsAffected = session.insert("com.example.psktask.mybatis.dao.CourseMapper.create", course);
//            }
//            return rowsAffected;
//        }
//    }
//    private com.example.psktask.entities.Course convertModelToEntity(Course course) {
//        com.example.psktask.entities.Course entity = new com.example.psktask.entities.Course();
//        entity.setId(course.getId());
//        entity.setName(course.getName());
//        entity.setYear(course.getYear());
//        entity.setUniversity(universityDAO.findById(course.getUniversityId()));
//        entity.setSpecialty(course.getSpecialty());
//
//        return entity;
//    }
//
//    private Course convertEntityToModel(com.example.psktask.entities.Course course) {
//        Course model = new Course();
//        model.setId(course.getId());
//        model.setName(course.getName());
//        model.setYear(course.getYear());
//        model.setUniversityId(course.getUniversity().getId());
//        model.setSpecialty(course.getSpecialty());
//
//        return model;
//    }
//}