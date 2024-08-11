package unibl.etf.ip.fitnessappbackend.dtos;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serializable;

@Data
public class PictureDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotBlank
    private Integer id;
    @NotBlank
    private String name;
    @NotBlank
    private Integer programId;
    @NotBlank
    private Integer cover;

}
