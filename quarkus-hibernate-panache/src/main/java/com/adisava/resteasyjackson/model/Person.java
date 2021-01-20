package com.adisava.resteasyjackson.model;

import com.adisava.resteasyjackson.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Person extends PanacheEntity {

    public String name;

    @JsonFormat(pattern = "dd-MM-yyyy")
    public LocalDate birth;

    @Enumerated(EnumType.STRING)
    public Status status;

    public static Person findByName(String name){
        return find("name", name).firstResult();
    }

    public static List<Person> findAlive(){
        return list("status", Status.ALIVE);
    }

    public static void addPerson(Person person) {
        person.persist();
    }

    public static void deleteStefs(){
        delete("name", "Stef");
    }
}
