package unibl.etf.ip.fitnessappbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import unibl.etf.ip.fitnessappbackend.models.Attribute;

import java.util.List;

public interface AttributeRepository extends JpaRepository<Attribute, String>, JpaSpecificationExecutor<Attribute> {
    List<Attribute> findAllByCategoryName(String categoryName);
}