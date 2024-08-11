package unibl.etf.ip.fitnessappbackend.idClasses;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class DayId implements Serializable {
    private Date date;
    private Integer diaryId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DayId dayId = (DayId) o;
        return Objects.equals(date, dayId.date) && Objects.equals(diaryId, dayId.diaryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, diaryId);
    }
}
