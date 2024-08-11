package unibl.etf.ip.fitnessappbackend.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginDTO {
    @NotBlank
    String username;
    @NotBlank
    String password;
}
