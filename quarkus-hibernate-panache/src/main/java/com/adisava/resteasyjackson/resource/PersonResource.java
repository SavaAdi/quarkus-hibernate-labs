package com.adisava.resteasyjackson.resource;

import com.adisava.resteasyjackson.enums.Status;
import com.adisava.resteasyjackson.model.Person;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.time.LocalDate;

@Path("/person")
public class PersonResource {

    @Transactional
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void savePerson(Person person) {
        person.persist();
    }

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
