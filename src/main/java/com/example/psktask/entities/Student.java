package com.example.psktask.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Student {
    @Id
    @GeneratedValue
    private Long id;

    @Basic(optional = false)
    private String name;

    @Basic(optional = false)
    private String surname;

    @ManyToOne
    private University university;

    @ManyToMany(mappedBy = "students")
    private List<Course> courses;


}
