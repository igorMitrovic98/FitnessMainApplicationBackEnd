package unibl.etf.ip.fitnessappbackend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import unibl.etf.ip.fitnessappbackend.idClasses.DayId;

import java.io.Serializable;
import java.sql.Date;
@Setter
@Getter
@Entity
@Table
@IdClass(DayId.class)
public class Day implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private Date date;

    private String excersiseType;

    private Integer duration;

    private Integer intensity;

    private Integer result;

    private Double weight;
    @Id
    private Integer diaryId;

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
