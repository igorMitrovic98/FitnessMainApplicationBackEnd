package unibl.etf.ip.fitnessappbackend.repositories;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import unibl.etf.ip.fitnessappbackend.models.Program;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface ProgramRepository extends JpaRepository<Program, Integer>, JpaSpecificationExecutor<Program> {
    List<Program> findAllByUsername(String username);
    List<Program> findAllByCategoryName(String name);
    @Nonnull
    Page<Program> findAll(Pageable pageable);
}