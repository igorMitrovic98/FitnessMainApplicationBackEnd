package unibl.etf.ip.fitnessappbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.transaction.annotation.Transactional;
import unibl.etf.ip.fitnessappbackend.models.Subscription;

import java.util.List;

public interface SubscriptionRepository extends JpaRepository<Subscription, String>, JpaSpecificationExecutor<Subscription> {
    @Transactional
    void deleteByUsernameAndCategoryName(String id,String id2);
    Subscription findByUsernameAndCategoryName(String id,String id2);
    List<Subscription> findAllByUsername(String username);
}