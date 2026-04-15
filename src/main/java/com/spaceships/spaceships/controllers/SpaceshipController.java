package com.spaceships.spaceships.controllers;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.spaceships.spaceships.models.Spaceship;
import com.spaceships.spaceships.services.SpaceshipService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@RestController
public class SpaceshipController {

    private SpaceshipService spaceshipService;

    public SpaceshipController(SpaceshipService spaceshipService) {
        this.spaceshipService = spaceshipService;
    }
    
    @GetMapping
    public String getRoot() {
        return "{'Hello': 'World!'}";
    }

    @GetMapping("/spaceships")
    public List<Spaceship> getShips() {
        return spaceshipService.getShips();
    }
    
        @GetMapping("/spaceships/{world}")
        public List<Spaceship> getShipsByWorld(@PathVariable String world) {
            return spaceshipService.getShipByWorld(world);
        }

    @GetMapping("/spaceship/{id}")
    public Spaceship getShip(@PathVariable String id) {
        return spaceshipService.getShip(id);
    }

    @PostMapping("/spaceship")
    public Spaceship addSpaceship(@RequestBody Spaceship spaceship) {
        return spaceshipService.addSpaceship(spaceship);
    }

    @PatchMapping("/spaceship/{id}")
    public Spaceship editSpaceship(@PathVariable String id, @RequestBody Spaceship spaceship) {
        return spaceshipService.editSpaceship(id, spaceship);
    }

    @DeleteMapping("/spaceship/{id}")
    public String deleteSpaceship(@PathVariable String id) {
        spaceshipService.deleteSpaceship(id);
        // OBS - Meddelandet returneras oavsett om Id hittades eller inte
        return "{'message': 'Spaceship with id " + id + " has been deleted'}";
    }
    
}
