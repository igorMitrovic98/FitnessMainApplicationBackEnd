package unibl.etf.ip.fitnessappbackend.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import unibl.etf.ip.fitnessappbackend.dtos.NewsDTO;
import unibl.etf.ip.fitnessappbackend.services.NewsService;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {
    private static final Logger logger = LogManager.getLogger(NewsController.class);

    @Autowired
    private NewsService newsService;

    @GetMapping
    public List<NewsDTO> getNews(){
        logger.info("Getting the news from the extern API");
        return newsService.getNews();
    }
}
