package unibl.etf.ip.fitnessappbackend.dtos;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serializable;

@Data
public class InstructorDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotBlank
    private Integer id;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private Integer age;
    @NotBlank
    private Integer experience;

}
