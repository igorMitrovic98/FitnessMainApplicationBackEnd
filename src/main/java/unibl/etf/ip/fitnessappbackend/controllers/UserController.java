package unibl.etf.ip.fitnessappbackend.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;
import unibl.etf.ip.fitnessappbackend.dtos.ActivationDTO;
import unibl.etf.ip.fitnessappbackend.dtos.LoginDTO;
import unibl.etf.ip.fitnessappbackend.dtos.UserDTO;
import unibl.etf.ip.fitnessappbackend.models.User;
import unibl.etf.ip.fitnessappbackend.services.UserService;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LogManager.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> save(@RequestBody UserDTO userDTO) {
        logger.info("Creating new user.");
        return userService.save(userDTO);
    }
    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody LoginDTO loginDTO){
        logger.info("Signing into the account.");
        return userService.login(loginDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        userService.delete(id);
    }

    @PutMapping("/{username}")
    public ResponseEntity<User> update(@PathVariable("username") String username,
                       @RequestBody UserDTO userDTO) {
        logger.info("Updating the user "+username);
      return  userService.update(username, userDTO);
    }

    @GetMapping("/{username}")
    public User getById(@PathVariable("username") String username) {
        logger.info("Getting the user "+username);
        return userService.requireOne(username);
    }

    @GetMapping("/all")
    public List<User> getAll() {
        logger.info("Getting all the users.");
        return userService.requireAll();
    }

    @PutMapping("/activate")
    public ResponseEntity<User> activate(@RequestBody ActivationDTO activationDTO){
        logger.info("Setting the user "+activationDTO.getUsername()+" account active.");
        return userService.activate(activationDTO.getUsername());
    }
    @PutMapping("/nonactive")
    public ResponseEntity<User> nonactive(@RequestBody LoginDTO loginDTO){
        logger.info("Sending the activation form to the mail.");
        return userService.nonactive(loginDTO);
    }
}
