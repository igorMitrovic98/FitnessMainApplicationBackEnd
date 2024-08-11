package unibl.etf.ip.fitnessappbackend.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unibl.etf.ip.fitnessappbackend.dtos.SubscriptionDTO;
import unibl.etf.ip.fitnessappbackend.models.Subscription;
import unibl.etf.ip.fitnessappbackend.services.SubscriptionService;

import java.util.List;


@RestController
@RequestMapping("/subscription")
public class SubscriptionController {

    private static final Logger logger = LogManager.getLogger(PictureController.class);

    @Autowired
    private SubscriptionService subscriptionService;

    @PostMapping
    public String save(@RequestBody SubscriptionDTO subscriptionDTO) {
        logger.info("Creating a new category subscription");
        return subscriptionService.save(subscriptionDTO);
    }

    @DeleteMapping("/{id}/{id2}")
    public void delete(@PathVariable("id") String id,@PathVariable("id2")String id2) {
        logger.info("Deleting a category subscription");
        subscriptionService.delete(id,id2);
    }


    @GetMapping("/{username}")
    public List<Subscription> getAll(@PathVariable("username")String username){

        logger.info("Getting the category subscriptions for user "+username);

        return subscriptionService.getAll(username);
    }

}
