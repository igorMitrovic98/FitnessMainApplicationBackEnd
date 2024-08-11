package unibl.etf.ip.fitnessappbackend.services;

import org.springframework.stereotype.Service;
import unibl.etf.ip.fitnessappbackend.dtos.NewsDTO;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import com.rometools.utils.*;

@Service
public class NewsService {

    public List<NewsDTO> getNews(){
        List<NewsDTO> value = new ArrayList<>();
        try {
            String newsURL = "https://feeds.feedburner.com/AceFitFacts";
            URL source = new URL(newsURL);
            SyndFeedInput input = new SyndFeedInput();
            SyndFeed newFeed = input.build(new XmlReader(source));
            for (SyndEntry entry : newFeed.getEntries()) {
                NewsDTO item = new NewsDTO();
                item.setCategory(entry.getCategories().get(0).getName());
                item.setTitle(entry.getTitle());
                item.setDescription(entry.getDescription().getValue());
                item.setLink(entry.getLink());
                value.add(item);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return value;
    }
}
