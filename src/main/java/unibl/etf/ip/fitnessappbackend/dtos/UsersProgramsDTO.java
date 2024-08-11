package unibl.etf.ip.fitnessappbackend.dtos;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
public class UsersProgramsDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotBlank
    private String username;
    @NotBlank
    private Integer programId;
    @NotBlank
    private Date date;
    @NotBlank
    private String payment;

}
