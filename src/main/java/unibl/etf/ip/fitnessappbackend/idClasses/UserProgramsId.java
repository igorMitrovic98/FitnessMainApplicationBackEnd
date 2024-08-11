package unibl.etf.ip.fitnessappbackend.idClasses;

import java.io.Serializable;
import java.util.Objects;

public class UserProgramsId implements Serializable {
    private String username;
    private Integer programId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserProgramsId that = (UserProgramsId) o;
        return Objects.equals(username, that.username) && Objects.equals(programId, that.programId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, programId);
    }
}
