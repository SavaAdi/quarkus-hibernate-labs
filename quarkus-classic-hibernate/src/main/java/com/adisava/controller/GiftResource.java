package com.adisava.controller;

import com.adisava.model.Gift;
import com.adisava.service.SantaClausService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


@Path("/gifts")
public class GiftResource {

    @Inject
    SantaClausService santaClausService;

    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public String addGift(String giftDescription){
        santaClausService.createGift(giftDescription);
        return giftDescription;
    }

    @GET
    @Path("/{giftId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Gift getGift(@PathParam("giftId") String giftId){
        var giftResult = santaClausService.getGift(Long.parseLong(giftId));
        System.out.println(giftResult);
        return giftResult;
    }
}
