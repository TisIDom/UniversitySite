package com.example.psktask.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class University {
    @Id
    @GeneratedValue
    private Long id;

    @Basic(optional = false)
    private String name;

    @OneToMany(mappedBy = "university")
    private List<Course> courses;

    @OneToMany(mappedBy = "university")
    private List<Student> students;

}
