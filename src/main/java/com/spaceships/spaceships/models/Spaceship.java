package com.spaceships.spaceships.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document(collection = "Spaceships")
public class Spaceship {
    @Id
    private String id;
    private String shipName;
    private String captain;
    private int crew;
    private int size;

    @DocumentReference
    private World world;

    public Spaceship(String id, String shipName, String captain, int crew, int size, World world) {
        this.id = id;
        this.shipName = shipName;
        this.captain = captain;
        this.crew = crew;
        this.size = size;
        this.world = world;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getCaptain() {
        return captain;
    }

    public void setCaptain(String captain) {
        this.captain = captain;
    }

    public int getCrew() {
        return crew;
    }

    public void setCrew(int crew) {
        this.crew = crew;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    
    
}
