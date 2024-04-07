

package com.example.psktask.beans;

import com.example.psktask.entities.Course;
import com.example.psktask.persistence.CourseDAO;
import com.example.psktask.persistence.UniversityDAO;
import com.example.psktask.entities.University;
import lombok.Setter;
import javax.transaction.Transactional;

import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@Named
@RequestScoped
public class UniversityBean implements Serializable {

    @Inject
    private UniversityDAO universityDAO;

    @Setter
    private University newUniversity;
    private List<University> allUniversities;

    public void loadAllUniversities() {
        allUniversities = universityDAO.findAll();
    }

    @Transactional
    public void addUniversity() {
        universityDAO.create(newUniversity);
        newUniversity = new University();
        loadAllUniversities();
    }

    public List<University> getAllUniversities() {
        if (allUniversities == null) {
            loadAllUniversities();
        }
        return allUniversities;
    }

    public University getNewUniversity() {
        if (newUniversity == null) {
            newUniversity = new University();
        }
        return newUniversity;
    }

    public List<Course> getCourses(long universityId){
        University university = universityDAO.findById(universityId);

        if (university == null) {
            return Collections.emptyList();
        }

        return university.getCourses();
    }

    public University getUniversity(long universityId){
        return universityDAO.findById(universityId);
    }
}

