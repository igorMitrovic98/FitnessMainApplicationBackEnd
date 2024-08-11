package unibl.etf.ip.fitnessappbackend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import unibl.etf.ip.fitnessappbackend.idClasses.SubscriptionId;

import java.io.Serializable;
import java.sql.Date;

@Setter
@Getter
@Entity
@Table
@IdClass(SubscriptionId.class)
public class Subscription implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String username;
    @Id
    private String categoryName;

    private Date date;

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
