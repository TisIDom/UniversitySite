/*
package com.example.psktask.beans;

import com.example.psktask.persistence.StudentDAO;
import com.example.psktask.entities.Student;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@RequestScoped
public class StudentBean implements Serializable {

    @Inject
    private StudentDAO studentDAO;

    private List<Student> allStudents;

    public void loadAllStudents() {
        allStudents = studentDAO.getAll();
    }

    public List<Student> getAllStudents() {
        if (allStudents == null) {
            loadAllStudents();
        }
        return allStudents;
    }
}
*/
