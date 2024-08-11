package unibl.etf.ip.fitnessappbackend.dtos;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
public class SubscriptionDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotBlank
    private String username;
    @NotBlank
    private String categoryName;
    @NotBlank
    private Date date;

}
