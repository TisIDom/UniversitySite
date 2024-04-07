/*
package com.example.psktask.rest;

import com.example.psktask.entities.Student;
import com.example.psktask.persistence.StudentDAO;
import com.example.psktask.rest.contracts.StudentDto;
import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("/students")
public class StudentController {

    @Inject
    @Setter @Getter
    private StudentDAO studentDAO;

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") final Long id) {
        Student student = studentDAO.getById(id);
        if (student == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        StudentDto studentDto = new StudentDto();
        studentDto.setName(student.getName());
        studentDto.setSurname(student.getSurname());
        studentDto.setUniversityName(student.getUniversity().getName());
        studentDto.setCourseName(student.getCourse().getName());


        return Response.ok(studentDto).build();
    }

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(
            @PathParam("id") final long studentId,
            StudentDto studentData) {
        try {
            Student existingStudent = studentDAO.getById(studentId);
            if (existingStudent == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            existingStudent.setName(studentData.getName());
            existingStudent.setSurname(studentData.getSurname());
            existingStudent.setUniversity(studentData.getUniversityName());
            existingStudent.setCourse(studentData.getUniversity().getName());
            studentDAO.update(existingStudent);
            return Response.ok().build();
        } catch (OptimisticLockException ole) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }
}
*/
