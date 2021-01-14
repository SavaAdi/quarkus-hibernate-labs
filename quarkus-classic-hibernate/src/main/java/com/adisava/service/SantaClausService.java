package com.adisava.service;

import com.adisava.model.Gift;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
public class SantaClausService {

    @Inject
    EntityManager em;

    @Transactional
    public void createGift(String giftDescription) {
        var gift = new Gift();
        gift.setName(giftDescription);
        em.persist(gift);
    }
}
