package unibl.etf.ip.fitnessappbackend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import unibl.etf.ip.fitnessappbackend.idClasses.AttributeValueId;

import java.io.Serializable;
@Setter
@Getter
@Entity
@Table
@IdClass(AttributeValueId.class)
public class AttributeValue implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private Integer programId;
    @Id
    private String attributeName;

    private String value;

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
