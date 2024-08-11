package unibl.etf.ip.fitnessappbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import unibl.etf.ip.fitnessappbackend.models.Message;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, String>, JpaSpecificationExecutor<Message> {
    void deleteByIdAndSenderName(Integer id,String id2);
    Message findByIdAndSenderName(Integer id,String id2);
    List<Message> findAllBySenderNameOrReceiverName(String id,String id2);

    @Modifying
    @Transactional
    @Query("UPDATE Message m SET m.seen = 1 WHERE m.senderName = ?1 AND m.receiverName = ?2 ")
    void updateSeenMessages(String u1,String u2);
}