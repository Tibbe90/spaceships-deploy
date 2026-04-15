package com.spaceships.spaceships.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Worlds")
public class World {
    
    @Id
    public String id;
    public String worldName;

    public World(String id, String worldName) {
        this.id = id;
        this.worldName = worldName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWorldName() {
        return worldName;
    }

    public void setWorldName(String worldName) {
        this.worldName = worldName;
    }

}
