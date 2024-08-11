package unibl.etf.ip.fitnessappbackend.controllers;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unibl.etf.ip.fitnessappbackend.dtos.LocationDTO;
import unibl.etf.ip.fitnessappbackend.models.Location;
import unibl.etf.ip.fitnessappbackend.services.LocationService;

import java.util.List;

@RestController
@RequestMapping("/location")
public class LocationController {
    private static final Logger logger = LogManager.getLogger(LocationController.class);

    @Autowired
    private LocationService locationService;


    @GetMapping("/{id}")
    public Location getById(@PathVariable("id") Integer id) {
        logger.info("Getting the location with id"+id);
        return locationService.getById(id);
    }

    @GetMapping
    public List<Location> getAll(){
        logger.info("Getting all the locations.");
        return locationService.getAll();
    }
}
