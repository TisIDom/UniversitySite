package com.example.psktask.rest.contracts;

import com.example.psktask.entities.Course;
import com.example.psktask.entities.Student;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class UniversityDto {

    private String Name;

    private List<Course> Courses;

    private List<Student> Students;

}
