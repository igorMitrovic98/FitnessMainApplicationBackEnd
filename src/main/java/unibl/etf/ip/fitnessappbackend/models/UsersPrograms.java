package unibl.etf.ip.fitnessappbackend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import unibl.etf.ip.fitnessappbackend.idClasses.UserProgramsId;

import java.io.Serializable;
import java.sql.Date;

@Setter
@Getter
@Entity
@Table
@IdClass(UserProgramsId.class)
public class UsersPrograms implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String username;
    @Id
    private Integer programId;

    private Date date;

    private String payment;

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
