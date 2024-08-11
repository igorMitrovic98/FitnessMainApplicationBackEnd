package unibl.etf.ip.fitnessappbackend.dtos;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serializable;

@Data
public class ReplyDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    @NotBlank
    private String content;
    @NotBlank
    private Integer questionId;
    @NotBlank
    private String username;

}
