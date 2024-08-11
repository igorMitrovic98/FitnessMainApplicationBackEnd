package unibl.etf.ip.fitnessappbackend.dtos;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
public class DayDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotBlank
    private Date date;

    private String excersiseType;

    private Integer duration;

    private Integer intensity;

    private Integer result;

    private Double weight;

    private Integer diaryId;

}
