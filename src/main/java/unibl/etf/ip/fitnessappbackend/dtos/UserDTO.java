package unibl.etf.ip.fitnessappbackend.dtos;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;



import java.io.Serializable;

@Data
public class UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotBlank
    private String username;
    @NotBlank
    private String password;
    @NotBlank
    private String city;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    @Email
    private String email;
    private Integer activated;

}
