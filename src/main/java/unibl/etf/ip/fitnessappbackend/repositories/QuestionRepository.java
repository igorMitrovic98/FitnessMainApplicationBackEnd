package unibl.etf.ip.fitnessappbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import unibl.etf.ip.fitnessappbackend.models.Question;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer>, JpaSpecificationExecutor<Question> {
    void deleteByIdAndUsernameAndProgramId(Integer id,String id2,Integer id3);
    Question findByIdAndUsernameAndProgramId(Integer id,String id2,Integer id3);
    List<Question> findAllByProgramId(Integer id);
}