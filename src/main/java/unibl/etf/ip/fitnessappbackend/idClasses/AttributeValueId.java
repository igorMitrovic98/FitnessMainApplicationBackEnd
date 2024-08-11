package unibl.etf.ip.fitnessappbackend.idClasses;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
public class AttributeValueId  implements Serializable {
    private Integer programId;
    private String attributeName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AttributeValueId that = (AttributeValueId) o;
        return Objects.equals(programId, that.programId) && Objects.equals(attributeName, that.attributeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(programId, attributeName);
    }
}
