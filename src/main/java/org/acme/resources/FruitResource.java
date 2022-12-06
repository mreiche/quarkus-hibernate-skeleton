package org.acme.resources;

import org.acme.models.Fruit;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/fruits")
public class FruitResource {

    @Inject
    EntityManager em;

    @GET
    public List<Fruit> list() {
        return this.em.createQuery("SELECT f FROM Fruit f", Fruit.class).getResultList();
    }

    @POST
    @Transactional
    public List<Fruit> add(final Fruit fruit) {
        this.em.persist(fruit);
        return this.list();
    }

    @DELETE
    @Transactional
    public List<Fruit> delete(final Fruit fruit) {
        this.em.merge(fruit);
        this.em.remove(fruit);
        return this.list();
    }
}
