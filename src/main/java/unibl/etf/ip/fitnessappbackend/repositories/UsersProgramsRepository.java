package unibl.etf.ip.fitnessappbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import unibl.etf.ip.fitnessappbackend.models.UsersPrograms;

import java.util.List;

public interface UsersProgramsRepository extends JpaRepository<UsersPrograms, Integer>, JpaSpecificationExecutor<UsersPrograms> {
    void deleteByUsernameAndProgramId(String id,Integer id2);
    UsersPrograms findByUsernameAndProgramId(String id,Integer id2);
    List<UsersPrograms> findAllByUsername(String username);
}