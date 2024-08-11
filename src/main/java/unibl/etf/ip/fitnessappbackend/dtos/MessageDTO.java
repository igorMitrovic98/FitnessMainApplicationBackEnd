package unibl.etf.ip.fitnessappbackend.dtos;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class MessageDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    @NotBlank
    private String content;
    @NotBlank
    private Integer seen;
    @NotBlank
    private String senderName;
    @NotBlank
    private String receiverName;

}
