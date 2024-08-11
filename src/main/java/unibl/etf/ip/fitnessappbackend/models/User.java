package unibl.etf.ip.fitnessappbackend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Setter
@Getter
@Entity
@Table
public class User implements Serializable {

    private static final long serialVersionUID = 1L;


    @Id
    private String username;

    private String password;

    private String city;

    private String firstName;

    private String lastName;

    private String email;

    private Integer activated;

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
