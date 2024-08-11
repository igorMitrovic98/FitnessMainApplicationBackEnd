package unibl.etf.ip.fitnessappbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import unibl.etf.ip.fitnessappbackend.models.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Integer>, JpaSpecificationExecutor<Instructor> {

}