package unibl.etf.ip.fitnessappbackend.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import unibl.etf.ip.fitnessappbackend.ImageUtils;
import unibl.etf.ip.fitnessappbackend.dtos.PictureDTO;
import unibl.etf.ip.fitnessappbackend.models.Picture;
import unibl.etf.ip.fitnessappbackend.repositories.PictureRepository;

import java.awt.*;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PictureService {

    @Autowired
    private PictureRepository pictureRepository;

    @Value("${programImages:}")
    private String dir;

    public Integer save(PictureDTO pictureDTO) {
        Picture bean = new Picture();
        BeanUtils.copyProperties(pictureDTO, bean);
        bean = pictureRepository.save(bean);
        return bean.getId();
    }

    public void delete(Integer id) {
        pictureRepository.deleteById(id);
    }

    public void update(Integer id, PictureDTO pictureDTO) {
        Picture bean = requireOne(id);
        BeanUtils.copyProperties(pictureDTO, bean);
        pictureRepository.save(bean);
    }

    public PictureDTO getById(Integer id) {
        Picture original = requireOne(id);
        return toDTO(original);
    }

    private PictureDTO toDTO(Picture original) {
        PictureDTO bean = new PictureDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Picture requireOne(Integer id) {
        return pictureRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }

    public List<Picture> getAll(){
        return pictureRepository.findAll();
    }

    public String savePicture(Integer programId, MultipartFile file){
        try {
            return ImageUtils.saveFile(dir, file);
        } catch (Exception e) {
            return null;
        }
    }

    public Picture createProgramPicture(Picture picture) {
        return pictureRepository.save(picture);
    }

    public byte[] getCoverPhoto(Integer id){
        Picture picture = pictureRepository.findByCoverAndProgramId(1,id);
        try {
            return ImageUtils.getImage(dir,picture.getName());
        }catch (Exception e){
            return new byte[0];
        }
    }

    public List<Picture> getAllProgramsPictures(Integer id){
        return pictureRepository.findAllByProgramId(id);
    }

    public byte[] getPictureByProgramIdAndName(Integer id,String name){
        try {
            return ImageUtils.getImage(dir,name);
        }catch (Exception e){
            return new byte[0];
        }
    }

}
