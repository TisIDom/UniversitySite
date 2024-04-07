package com.example.psktask.rest.contracts;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class StudentDto {

    private String Name;

    private String Surname;

    private String UniversityName;

    //private List<String> CourseNames;
}
