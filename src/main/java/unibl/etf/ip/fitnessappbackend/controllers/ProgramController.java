package unibl.etf.ip.fitnessappbackend.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unibl.etf.ip.fitnessappbackend.dtos.ProgramDTO;
import unibl.etf.ip.fitnessappbackend.models.Program;
import unibl.etf.ip.fitnessappbackend.services.ProgramService;

import java.util.List;


@RestController
@RequestMapping("/program")
public class ProgramController {

    private static final Logger logger = LogManager.getLogger(ProgramController.class);

    @Autowired
    private ProgramService programService;

    @PostMapping
    public Program save(@RequestBody ProgramDTO programDTO) {
        logger.info("Creating a new program.");
        return programService.save(programDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {

        logger.info("Deleting a program "+id);
        programService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") Integer id,
                       @RequestBody ProgramDTO programDTO) {
        logger.info("Updating a program "+id);
        programService.update(id, programDTO);
    }

    @GetMapping("/display/{id}")
    public Program getSingleProgram(@PathVariable("id") Integer id){
        logger.info("Getting the program "+id);
        return programService.getSingleProgram(id);
    }

    @GetMapping("/{username}")
    public List<Program> getById(@PathVariable("username") String username) {
        logger.info("Getting all the programs for user "+username);
        return programService.getByUsername(username);
    }

    @GetMapping
    public List<Program> getAll() {

        logger.info("Getting all of the applications programs");
        return programService.getAll();
    }
    @GetMapping("/paginator/{page}/{size}")
    public ResponseEntity<Page<Program>> getAllPaginator(@PathVariable("page")Integer pageNo,
                                                         @PathVariable("size") Integer pageSize
                                                        ) {
        Page<Program> programs = programService.getAllPaginator(pageNo, pageSize, "id");
        logger.info("Get all paginated programs");
        return ResponseEntity.ok(programs);

    }
}
