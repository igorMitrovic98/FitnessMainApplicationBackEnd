package unibl.etf.ip.fitnessappbackend.dtos;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serializable;

@Data
public class AttributeValueDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotBlank
    private Integer programId;
    @NotBlank
    private String attributeName;
    @NotBlank
    private String value;

}
