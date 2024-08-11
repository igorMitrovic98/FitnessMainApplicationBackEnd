package unibl.etf.ip.fitnessappbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import unibl.etf.ip.fitnessappbackend.models.Picture;

import java.util.List;

public interface PictureRepository extends JpaRepository<Picture, Integer>, JpaSpecificationExecutor<Picture> {
    Picture findByCoverAndProgramId(Integer n,Integer id);
    List<Picture> findAllByProgramId(Integer id);
}