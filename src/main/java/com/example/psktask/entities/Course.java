package com.example.psktask.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Course {

    @Id
    @GeneratedValue
    private Long id;

    @Basic
    private String specialty;

    @Basic
    private Integer year;

    @ManyToOne
    private University university;

    @Basic(optional = false)
    private String name;

    @ManyToMany//(mappedBy = "course")
    private List<Student> students;

}
