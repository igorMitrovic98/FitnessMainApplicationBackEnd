package unibl.etf.ip.fitnessappbackend.dtos;

import lombok.Data;

@Data
public class NewsDTO {
    private String category;
    private String title;
    private String description;
    private String link;
}
