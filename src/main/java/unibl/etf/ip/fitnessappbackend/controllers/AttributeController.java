package unibl.etf.ip.fitnessappbackend.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unibl.etf.ip.fitnessappbackend.dtos.AttributeDTO;
import unibl.etf.ip.fitnessappbackend.models.Attribute;
import unibl.etf.ip.fitnessappbackend.services.AttributeService;

import java.util.List;


@RestController
@RequestMapping("/attribute")
public class AttributeController {

    @Autowired
    private AttributeService attributeService;


    @GetMapping("/{categoryName}")
    public List<Attribute> getById(@PathVariable("categoryName") String categoryName) {

        return attributeService.getByCategoryName(categoryName);
    }

}
