package unibl.etf.ip.fitnessappbackend.idClasses;

import java.io.Serializable;
import java.util.Objects;

public class SubscriptionId implements Serializable {
    private String username;
    private String categoryName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubscriptionId that = (SubscriptionId) o;
        return Objects.equals(username, that.username) && Objects.equals(categoryName, that.categoryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, categoryName);
    }
}
