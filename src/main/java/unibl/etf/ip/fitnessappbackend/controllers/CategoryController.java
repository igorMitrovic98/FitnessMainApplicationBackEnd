package unibl.etf.ip.fitnessappbackend.controllers;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unibl.etf.ip.fitnessappbackend.dtos.CategoryDTO;
import unibl.etf.ip.fitnessappbackend.models.Category;
import unibl.etf.ip.fitnessappbackend.services.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private static final Logger logger = LogManager.getLogger(CategoryController.class);

    @Autowired
    private CategoryService categoryService;


    @GetMapping
    public List<Category> getAll(){
        logger.info("Getting all the categories.");
        return categoryService.getAll();
    }
}
