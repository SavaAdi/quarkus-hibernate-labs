package com.adisava.resteasyjackson.resource;

import com.adisava.resteasyjackson.enums.Status;
import com.adisava.resteasyjackson.model.Person;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.time.LocalDate;

@ApplicationScoped
@Path("/person")
public class PersonResource {

    @POST
    @Transactional
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createDeveloper(@Valid Person person) {
        person.persist();

        return Response.created(
                UriBuilder
                        .fromResource(PersonResource.class)
                        .path(person.name)
                        .build()
        )
                .entity(person)
                .build();
    }

//    @Transactional
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    public void savePerson(Person person) {
//        person.persist();
//    }

    @Transactional
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{personName}")
    public Person getPersonByName(@PathParam("personName") String person) {
        return Person.findByName(person);
    }

    @GET
    @Path("/example")
    public Person getPersonJSONExample(){
        var newPerson = new Person();
        newPerson.name = "An Example";
        newPerson.birth = LocalDate.now().minusYears(25L);
        newPerson.status = Status.ALIVE;
        return newPerson;
    }
}
