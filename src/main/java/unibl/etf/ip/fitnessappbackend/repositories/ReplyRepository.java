package unibl.etf.ip.fitnessappbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import unibl.etf.ip.fitnessappbackend.models.Reply;

public interface ReplyRepository extends JpaRepository<Reply, String>, JpaSpecificationExecutor<Reply> {
    void deleteByQuestionIdAndUsername(Integer id,String id2);
    Reply findByQuestionIdAndUsername(Integer id,String id2);
    Reply findByQuestionId(Integer id);
}