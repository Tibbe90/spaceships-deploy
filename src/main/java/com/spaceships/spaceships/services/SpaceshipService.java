package com.spaceships.spaceships.services;

import java.util.List;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.spaceships.spaceships.models.Spaceship;

@Service
public class SpaceshipService {
    private final MongoOperations mongoOperations;

    public SpaceshipService(MongoOperations mongoOperations, WorldRepository worldRepository) {
        this.mongoOperations = mongoOperations;
    }

    public Spaceship addSpaceship(Spaceship spaceship) {
        return mongoOperations.insert(spaceship);
    }

    public List<Spaceship> getShips() {
        return mongoOperations.findAll(Spaceship.class);
    }

    public Spaceship getShip(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        return mongoOperations.findOne(query, Spaceship.class);
    }

    public List<Spaceship> getShipByWorld(String world) {
        Query query = new Query();
        query.addCriteria(Criteria.where("world").is(world));
        return mongoOperations.find(query, Spaceship.class);
    }

    //Den här funktionen gör samma sak som editSpaceship nedan
    // public Spaceship editSpaceship(String id, Spaceship spaceship) {
    //     Query query = Query.query(Criteria.where("id").is(id));
    //     Update update = Update.update("captain", spaceship.getCaptain());

    //     mongoOperations.updateFirst(query, update, Spaceship.class);
    //     return mongoOperations.findById(id, Spaceship.class);
    // }

    public Spaceship editSpaceship(String id, Spaceship spaceship) {
        spaceship.setId(id);
        return mongoOperations.save(spaceship);
    }

    public void deleteSpaceship(String id) {
        Query query = Query.query(Criteria.where("id").is(id));

        mongoOperations.remove(query, Spaceship.class);
    }

}

/*
Från plugga.tech
Criteria: Filtering methods / Operators
Det går att skriva avancerade querys för att söka efter dokument i en mongoDB databas.

Grunden för att skriva en Criteria ser ut som:

Query query = new Query();
query.addCriteria(Criteria.where("id").is(id));
mongoOperations.findOne(query, FlightPlan.class);
Det du kan se i exemplet ovan är att skapa en Query med en Criteria som letar efter ett nyckel-värde för "id" som är samma som variabler id.

Som .is() kan man även söka som .ne() där is = equals och ne står för not equal.

Det går även att skriva kriterier som .lt() eller .lte() som står för "less than" eller "less than or equal".

Eller på samma vis med .gt() eller .gte() = "greater than" eller "greater than or equal".

Det går även att söka efter innehåll i en lista med .in().

Eller för att se om ett värde existerar i ett dokument med .exists().

Mer avancerade jämförelser går att skriva med regular experssions med .regex().

Compound Query Methods
Det går även att skriva querys med OR och AND metoder för att skapa avancerade sökningar.

.orOperator()

.andOperator()

.norOperator()

.not()
*/