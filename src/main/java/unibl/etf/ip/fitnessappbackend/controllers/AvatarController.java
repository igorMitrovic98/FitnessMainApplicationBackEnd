package unibl.etf.ip.fitnessappbackend.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import unibl.etf.ip.fitnessappbackend.dtos.AvatarDTO;
import unibl.etf.ip.fitnessappbackend.models.Avatar;
import unibl.etf.ip.fitnessappbackend.services.AvatarService;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.MediaType;

import java.util.Optional;

@RestController
@RequestMapping("/avatars")
public class AvatarController {
    private final AvatarService avatarService;
    private static final Logger logger = LogManager.getLogger(AvatarController.class);

    public AvatarController(AvatarService avatarService) {
        this.avatarService = avatarService;
    }

    @PostMapping("/{username}")
    public ResponseEntity<Avatar> createDefaultAvatar(@PathVariable String username) {
        AvatarDTO avatarDTO = new AvatarDTO();
        avatarDTO.setUsername(username);
        avatarDTO.setContent("default.png");
        System.out.println("AVATAR IME:" + username);
        Avatar avatar = avatarService.createAvatar(avatarDTO);
        logger.info("Avatar added for user "+username);
        return ResponseEntity.ok(avatar);

    }

    @PostMapping
    public ResponseEntity<Avatar> createAvatar(@RequestParam("avatar")MultipartFile file, @RequestParam("username") String username) {
        AvatarDTO avatarDTO = new AvatarDTO();
        avatarDTO.setUsername(username);
        String name = avatarService.saveImage(username, file);
        if (name == null) {
            logger.error("Creating avatar BAD REQUEST.");
            return ResponseEntity.badRequest().build();
        }

        avatarDTO.setContent(name);

        Avatar avatar = avatarService.createAvatar(avatarDTO);
        logger.info("Successfully created avatar.");
        return ResponseEntity.ok(avatar);
    }

    @PutMapping()
    public ResponseEntity<Avatar> updateAvatarByUsername(@RequestParam("username") String username, @RequestParam("avatar") MultipartFile file) {
        Optional<Avatar> avatarOptional = avatarService.getAvatarByUsername(username);

        if (avatarOptional.isEmpty()) {
            logger.error("Avatar not found for the update.");
            return ResponseEntity.notFound().build();
        }

        Avatar avatar = avatarOptional.get();

        String name = avatarService.saveImage(username, file);
        if (name == null) {
            logger.error("PUT AVATAR bad request.");
            return ResponseEntity.badRequest().build();
        }

        avatar.setContent(name);

        try {
            logger.info("Successfully updated a new avatar.");
            avatarService.updateAvatar(avatar.getId(), avatar);
        } catch (Exception e) {
            logger.error("No content to update.");
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(avatar);
    }

    @GetMapping(value = "/{username}", produces = MediaType.IMAGE_PNG_VALUE)
    public @ResponseBody byte[] getAvatarByUserId(@PathVariable("username") String username) {
        Optional<Avatar> avatar = avatarService.getAvatarByUsername(username);
        if (avatar.isEmpty()){
            logger.error("Avatar is not found for the user "+username);
            return new byte[0];
        }
        logger.info("Avatar is found for the user "+username);
        return avatarService.getImage(avatar.get().getContent());
    }
}