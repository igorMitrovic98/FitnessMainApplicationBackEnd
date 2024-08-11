package unibl.etf.ip.fitnessappbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import unibl.etf.ip.fitnessappbackend.models.Avatar;

import java.util.Optional;

public interface AvatarRepository extends JpaRepository<Avatar, Integer>, JpaSpecificationExecutor<Avatar> {
    Optional<Avatar> getAvatarByUsername(String username);
}