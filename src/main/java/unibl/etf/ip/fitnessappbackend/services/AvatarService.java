package unibl.etf.ip.fitnessappbackend.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import unibl.etf.ip.fitnessappbackend.ImageUtils;
import unibl.etf.ip.fitnessappbackend.dtos.AvatarDTO;
import unibl.etf.ip.fitnessappbackend.models.Avatar;
import unibl.etf.ip.fitnessappbackend.repositories.AvatarRepository;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AvatarService {

    @Autowired
    private AvatarRepository avatarRepository;

    @Value("${userImages:}")
    private String dir;

    public Avatar createAvatar(AvatarDTO avatarRequest) {
        Avatar avatar = new Avatar();
        avatar.setUsername(avatarRequest.getUsername());
        avatar.setContent(avatarRequest.getContent());
        return avatarRepository.save(avatar);
    }


    public String saveImage(String username, MultipartFile multipartFile) {
        try {
            return ImageUtils.saveFile(dir, multipartFile);
        } catch (Exception e) {
            return null;
        }
    }
    public Optional<Avatar> getAvatarByUsername(String username) {
        return avatarRepository.getAvatarByUsername(username);
    }

    public byte[] getImage(String name) {
        try {
            return ImageUtils.getImage(dir, name);
        } catch (Exception e) {
            return new byte[0];
        }
    }
    public Avatar updateAvatar(Integer id, Avatar avatar) throws Exception {

        return avatarRepository.save(avatar);
    }

}
