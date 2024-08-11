package unibl.etf.ip.fitnessappbackend.dtos;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serializable;

@Data
public class ProgramDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotBlank
    private Integer id;
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @NotBlank
    private Double price;
    @NotBlank
    private Integer level;
    @NotBlank
    private Integer duration;
    @NotBlank
    private String kontakt;
    @NotBlank
    private String username;
    @NotBlank
    private Integer instructorId;
    @NotBlank
    private Integer locationId;
    @NotBlank
    private String categoryName;

}
