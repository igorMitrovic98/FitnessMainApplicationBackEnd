package unibl.etf.ip.fitnessappbackend.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import unibl.etf.ip.fitnessappbackend.dtos.ReplyDTO;
import unibl.etf.ip.fitnessappbackend.models.Reply;
import unibl.etf.ip.fitnessappbackend.services.ReplyService;

import java.util.List;


@RestController
@RequestMapping("/reply")
public class ReplyController {

    private static final Logger logger = LogManager.getLogger(PictureController.class);

    @Autowired
    private ReplyService replyService;

    @PostMapping
    public String save(@RequestBody ReplyDTO replyDTO) {
        logger.info("Creating a reply");
        return replyService.save(replyDTO).toString();
    }



    @GetMapping("/{id}")
    public Reply getById(@PathVariable("id") Integer id) {
        Reply reply = replyService.getByQuestionId(id);
        if(reply != null){
            logger.info("Getting a reply for the question "+id);
            return reply;
        }
        logger.info("Reply for the question "+id+" not found.");
        return null;
    }


}
