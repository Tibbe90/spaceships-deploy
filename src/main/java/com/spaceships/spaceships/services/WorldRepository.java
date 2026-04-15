package com.spaceships.spaceships.services;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Update;

import com.spaceships.spaceships.models.World;

public interface WorldRepository extends MongoRepository<World, String> {
    
    World findByWorldNameIgnoreCase(String worldName);

    @Update("{'$set': {'worldName': ?1}}")
    public void findAndSetNameById(String id, String newName);
}
