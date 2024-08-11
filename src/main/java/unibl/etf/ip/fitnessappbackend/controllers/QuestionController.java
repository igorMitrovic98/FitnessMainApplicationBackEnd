package unibl.etf.ip.fitnessappbackend.controllers;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unibl.etf.ip.fitnessappbackend.dtos.QuestionDTO;
import unibl.etf.ip.fitnessappbackend.models.Question;
import unibl.etf.ip.fitnessappbackend.services.QuestionService;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
    private static final Logger logger = LogManager.getLogger(QuestionController.class);

    @Autowired
    private QuestionService questionService;

    @PostMapping
    public String save(@RequestBody QuestionDTO questionDTO) {
        logger.info("Creating a question");
        return questionService.save(questionDTO).toString();
    }


    @GetMapping("/all/{id}")
    public List<Question> getByProgramId(@PathVariable("id") Integer id) {
        logger.info("Getting the question for program "+id);
        return questionService.getByProgramId(id);
    }

}
