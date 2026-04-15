package com.spaceships.spaceships.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spaceships.spaceships.models.World;
import com.spaceships.spaceships.services.WorldService;

@RestController
public class WorldController {
    
    private WorldService worldService;

    public WorldController(WorldService worldService) {
        this.worldService = worldService;
    }

    @PostMapping("/world")
    public World addWorld(@RequestBody World world) {
        return worldService.addWorld(world);
    }

    @GetMapping("/world/name/{name}")
    public World getWorldByName(@PathVariable String name) {
        return worldService.getWorldByName(name);
    }

    @GetMapping("/world/id/{id}") 
    public World getWorldById(@PathVariable String id) {
        return worldService.getWorldById(id);
    }

    @PatchMapping("/world/{id}")
    public World editWorld(@PathVariable String id, @RequestBody World world) {
        return worldService.editWorld(id, world);
    }

    @DeleteMapping("/world/{id}")
    public String deleteWorld(@PathVariable String id) {
        worldService.deleteWorld(id);
        return "{}";
    }
}
