package unibl.etf.ip.fitnessappbackend.dtos;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serializable;

@Data
public class LocationDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotBlank
    private Integer id;
    @NotBlank
    private String name;

    private String address;

}
