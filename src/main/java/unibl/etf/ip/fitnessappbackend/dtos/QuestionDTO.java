package unibl.etf.ip.fitnessappbackend.dtos;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serializable;

@Data
public class QuestionDTO implements Serializable {
    private static final long serialVersionUID = 1L;


    @NotBlank
    private String content;
    @NotBlank
    private String username;
    @NotBlank
    private Integer programId;

}
