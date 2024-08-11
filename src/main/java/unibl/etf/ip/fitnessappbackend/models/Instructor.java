package unibl.etf.ip.fitnessappbackend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table
@Setter
@Getter
public class Instructor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private Integer id;

    private String firstName;

    private String lastName;

    private Integer age;

    private Integer experience;

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
