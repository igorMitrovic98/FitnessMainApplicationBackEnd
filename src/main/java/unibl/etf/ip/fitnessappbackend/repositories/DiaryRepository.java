package unibl.etf.ip.fitnessappbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import unibl.etf.ip.fitnessappbackend.models.Day;
import unibl.etf.ip.fitnessappbackend.models.Diary;

import java.util.Optional;
import java.util.List;

public interface DiaryRepository extends JpaRepository<Diary, Integer>, JpaSpecificationExecutor<Diary> {
    Optional<Diary> findByUsername(String username);
}