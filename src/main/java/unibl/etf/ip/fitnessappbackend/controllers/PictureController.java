package unibl.etf.ip.fitnessappbackend.controllers;


import org.apache.coyote.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import unibl.etf.ip.fitnessappbackend.dtos.PictureDTO;
import unibl.etf.ip.fitnessappbackend.models.Picture;
import unibl.etf.ip.fitnessappbackend.services.PictureService;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/picture")
public class PictureController {

    private static final Logger logger = LogManager.getLogger(PictureController.class);

    @Autowired
    private PictureService pictureService;

    @PostMapping
    public ResponseEntity<Object> save(@RequestParam("image") MultipartFile file, @RequestParam("programId") Integer programId, @RequestParam("cover") Integer cover) {
        Picture picture = new Picture();
        picture.setProgramId(programId);
        picture.setCover(cover);
        String name = pictureService.savePicture(programId, file);
        if (name == null) {
            logger.error("Bad request to create programs picture.");
            return ResponseEntity.badRequest().build();
        }

        picture.setName(name);
        logger.info("Picture for program "+programId+" created successfully.");
        Picture productImage = pictureService.createProgramPicture(picture);
        return ResponseEntity.ok(productImage);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        pictureService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") Integer id,
                       @RequestBody PictureDTO pictureDTO) {
        pictureService.update(id, pictureDTO);
    }

    @GetMapping(value = "/{id}",produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] getCoverPhoto(@PathVariable("id") Integer id) {
        logger.info("Getting the picture for the program "+id);
        return pictureService.getCoverPhoto(id);
    }

    @GetMapping("/all/{id}")
    public List<String> getAllProgramsPictures(@PathVariable("id") Integer id){
        List<Picture> list = pictureService.getAllProgramsPictures(id);
        List<String> pictures = new ArrayList<>();
        for(Picture p : list){
            pictures.add(p.getName());
        }
        logger.info("Getting all the pictures for the program "+id);
        return pictures;
    }
    @GetMapping(value = "/{programId}/{pictureName}", produces = MediaType.IMAGE_PNG_VALUE)
    public @ResponseBody byte[] getProgramImage(@PathVariable("programId") Integer programId,
                                                @PathVariable("pictureName") String pictureName){
        logger.info("Getting the picture for the program "+programId);
        return pictureService.getPictureByProgramIdAndName(programId,pictureName);
    }

    @GetMapping
    public List<Picture> getAll(){
        return pictureService.getAll();
    }
}
