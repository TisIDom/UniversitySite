package com.example.psktask.rest;

import com.example.psktask.entities.Student;
import com.example.psktask.entities.University;
import com.example.psktask.persistence.StudentDAO;
import com.example.psktask.persistence.UniversityDAO;
import com.example.psktask.rest.contracts.StudentDto;
import com.example.psktask.rest.contracts.UniversityDto;
import lombok.Getter;
import lombok.Setter;
import javax.transaction.Transactional;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Setter
@Getter
@ApplicationScoped
@Path("/universities")
public class UniversityController {

    @Inject
    private UniversityDAO universityDAO;

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") final Long id) {
        University university = universityDAO.findById(id);
        if (university == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        UniversityDto universityDto = new UniversityDto();
        universityDto.setName(university.getName());
        universityDto.setCourses(university.getCourses());
        universityDto.setStudents(university.getStudents());


        return Response.ok(universityDto).build();
    }

    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(
            @PathParam("id") final long universityId,
            UniversityDto universityData) {
        try {
            University existingUniversity = universityDAO.findById(universityId);
            if (existingUniversity == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            existingUniversity.setName(universityData.getName());
            existingUniversity.setCourses(universityData.getCourses());
            existingUniversity.setStudents(universityData.getStudents());
            universityDAO.save(existingUniversity);
            return Response.ok().build();
        } catch (OptimisticLockException ole) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }
}
