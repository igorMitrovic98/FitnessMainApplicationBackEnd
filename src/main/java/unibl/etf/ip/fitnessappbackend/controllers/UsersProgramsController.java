package unibl.etf.ip.fitnessappbackend.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unibl.etf.ip.fitnessappbackend.dtos.UsersProgramsDTO;
import unibl.etf.ip.fitnessappbackend.models.User;
import unibl.etf.ip.fitnessappbackend.models.UsersPrograms;
import unibl.etf.ip.fitnessappbackend.services.UsersProgramsService;

import java.util.List;

@RestController
@RequestMapping("/usersPrograms")
public class UsersProgramsController {

    private static final Logger logger = LogManager.getLogger(UsersProgramsController.class);

    @Autowired
    private UsersProgramsService usersProgramsService;

    @PostMapping("/{username}/{programId}")
    public String save(@RequestBody String payment,@PathVariable("username")String username,
                       @PathVariable("programId")Integer programId) {
        logger.info("Creating a purchase for the user "+username+" and the program "+programId);
        return usersProgramsService.save(payment,username,programId);
    }


    @GetMapping("/{username}/{id}")
    public boolean checkPurchase(@PathVariable("username")String username,@PathVariable("id")Integer programId){
        logger.info("Getting the purchase for the user "+username+" and the program "+programId);
        return usersProgramsService.getByUsernameAndProgramId(username,programId);
    }

    @GetMapping("/get/{username}")
    public List<UsersPrograms> getProgramIds(@PathVariable("username")String username){
        logger.info("Getting all of the purchases for the user "+username);
      return  usersProgramsService.getProgramIds(username);
    }
    @GetMapping("/one/{username}/{programid}")
    public UsersPrograms getSingle(@PathVariable("username")String username,@PathVariable("programid")Integer programid){
        logger.info("Getting a single purchase fo the user "+username+" and the program "+programid);
        return  usersProgramsService.getSingle(username,programid);
    }

}
