package unibl.etf.ip.fitnessappbackend.dtos;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serializable;

@Data
public class AttributeDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotBlank
    private String name;
    @NotBlank
    private String categoryName;

}
