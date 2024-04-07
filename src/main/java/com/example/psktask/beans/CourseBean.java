
package com.example.psktask.beans;

import com.example.psktask.entities.University;
import com.example.psktask.persistence.CourseDAO;
import com.example.psktask.entities.Course;
import com.example.psktask.entities.Student;
import com.example.psktask.persistence.UniversityDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Named
@RequestScoped
public class CourseBean implements Serializable {

    @Inject
    private CourseDAO courseDAO;

    @Inject
    private UniversityDAO universityDAO;

    private List<Course> allCourses;
    @Setter
    @Getter
    private Course selectedCourse;
    @Getter
    private List<Student> enrolledStudents;
    @Setter
    private Student newStudent;

    @Getter
    @Setter
    private Course newCourse = new Course();

    public Student getNewStudent() {
        if (newStudent == null) {
            newStudent = new Student();
        }
        return newStudent;
    }

    public University getUniversity(long universityId) {
        return universityDAO.findById(universityId);
    }

    @PostConstruct
    public void loadAllCourses()
    {
        allCourses = courseDAO.findAll();
    }

    public List<Course> getAllCourses()
    {
        if (allCourses == null) {
            loadAllCourses();
        }
        return allCourses;
    }

    @Transactional
    public String addCourse() {

        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Long universityId = Long.parseLong(requestParameters.get("universityId"));
        newCourse.setUniversity(universityDAO.findById(universityId));
        courseDAO.create(newCourse);

        newCourse = new Course();

        newCourse.setUniversity(universityDAO.findById(universityId));

        loadAllCourses();

        return "/courses?faces-redirect=true&universityId=" + universityId;
    }

    public List<Course> getAllCoursesByUniversity(long universityId) {
        return allCourses.stream()
                .filter(course -> course.getUniversity() != null)
                .filter(course -> course.getUniversity().getId() == universityId)
                .collect(Collectors.toList());
    }
}

