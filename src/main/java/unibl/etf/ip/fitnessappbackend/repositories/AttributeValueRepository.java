package unibl.etf.ip.fitnessappbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import unibl.etf.ip.fitnessappbackend.models.AttributeValue;

import java.util.List;

public interface AttributeValueRepository extends JpaRepository<AttributeValue, String>, JpaSpecificationExecutor<AttributeValue> {
    void deleteByProgramIdAndAttributeName(Integer id,String id2);
    AttributeValue findByProgramIdAndAttributeName(Integer id,String id2);
    List<AttributeValue> findAllByProgramId(Integer id);
}