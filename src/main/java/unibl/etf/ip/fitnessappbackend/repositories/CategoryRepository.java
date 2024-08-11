package unibl.etf.ip.fitnessappbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import unibl.etf.ip.fitnessappbackend.models.Category;

public interface CategoryRepository extends JpaRepository<Category, String>, JpaSpecificationExecutor<Category> {

}