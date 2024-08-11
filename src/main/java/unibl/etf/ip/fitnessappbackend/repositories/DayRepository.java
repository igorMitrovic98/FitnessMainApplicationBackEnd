package unibl.etf.ip.fitnessappbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import unibl.etf.ip.fitnessappbackend.models.Day;

import java.util.Date;
import java.util.List;

public interface DayRepository extends JpaRepository<Day, Integer>, JpaSpecificationExecutor<Day> {
    void deleteByDateAndDiaryId(Date id,Integer id2);
    Day findByDateAndDiaryId(Date id,Integer id2);
    List<Day> findAllByDiaryId(Integer diaryId);
}