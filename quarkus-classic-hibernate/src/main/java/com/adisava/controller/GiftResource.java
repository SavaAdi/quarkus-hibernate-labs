package com.adisava.controller;

import com.adisava.model.Gift;
import com.adisava.service.SantaClausService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

@Path("/gifts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GiftResource {

    @Inject
    SantaClausService santaClausService;

    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    public String addGift(String giftDescription){
        santaClausService.createGift(giftDescription);
        return giftDescription;
    }
}
