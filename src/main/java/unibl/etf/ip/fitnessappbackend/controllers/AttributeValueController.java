package unibl.etf.ip.fitnessappbackend.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unibl.etf.ip.fitnessappbackend.dtos.AttributeValueDTO;
import unibl.etf.ip.fitnessappbackend.models.AttributeValue;
import unibl.etf.ip.fitnessappbackend.services.AttributeValueService;

import java.util.List;


@RestController
@RequestMapping("/attributeValue")
public class AttributeValueController {

    private static final Logger logger = LogManager.getLogger(AttributeValueController.class);

    @Autowired
    private AttributeValueService attributeValueService;

    @PostMapping
    public String save(@RequestBody AttributeValueDTO attributeValueDTO) {
        logger.info("New value added to attributeValue.");
        return attributeValueService.save(attributeValueDTO);
    }


    @GetMapping("/{programId}")
    public List<AttributeValue> getForProgram(@PathVariable("programId") Integer id){
        logger.info("Getting all the attriuteValues for the program "+id);
        return attributeValueService.getForProgram(id);
    }
}
