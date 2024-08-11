package unibl.etf.ip.fitnessappbackend.controllers;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unibl.etf.ip.fitnessappbackend.dtos.InstructorDTO;
import unibl.etf.ip.fitnessappbackend.models.Instructor;
import unibl.etf.ip.fitnessappbackend.services.InstructorService;

import java.util.List;


@RestController
@RequestMapping("/instructor")
public class InstructorController {
    private static final Logger logger = LogManager.getLogger(InstructorController.class);

    @Autowired
    private InstructorService instructorService;



    @GetMapping("/{id}")
    public Instructor getById(@PathVariable("id") Integer id) {
        logger.info("Getting the instructor with the id "+id);
        return instructorService.getById(id);
    }

    @GetMapping
    public List<Instructor> getAll(){
        logger.info("Getting all the instructor.");
        return instructorService.getAll();
    }
}
