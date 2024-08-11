package unibl.etf.ip.fitnessappbackend.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unibl.etf.ip.fitnessappbackend.dtos.MessageDTO;
import unibl.etf.ip.fitnessappbackend.models.Message;
import unibl.etf.ip.fitnessappbackend.services.MessageService;

import java.util.List;


@RestController
@RequestMapping("/message")
public class MessageController {
    private static final Logger logger = LogManager.getLogger(AvatarController.class);

    @Autowired
    private MessageService messageService;

    @PostMapping
    public String save(@RequestBody MessageDTO messageDTO) {
        logger.info("Creating a new message.");
        return messageService.save(messageDTO);
    }


    @PutMapping("/{id}/{id2}")
    public void update(@PathVariable("id") String id,@PathVariable("id2")String id2,
                       @RequestBody Integer n) {
        logger.info("Updating a message.");
        messageService.update(id,id2,n);
    }

    @GetMapping("/{username}")
    public List<Message> getBySenderAndReceiver(@PathVariable("username") String username) {
        logger.info("Getting the messages for the user "+username);
        return messageService.getBySenderAndReceiver(username);
    }

}
