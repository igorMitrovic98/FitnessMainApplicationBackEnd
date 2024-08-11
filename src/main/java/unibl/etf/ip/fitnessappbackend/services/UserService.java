package unibl.etf.ip.fitnessappbackend.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import unibl.etf.ip.fitnessappbackend.dtos.LoginDTO;
import unibl.etf.ip.fitnessappbackend.dtos.UserDTO;
import unibl.etf.ip.fitnessappbackend.models.User;
import unibl.etf.ip.fitnessappbackend.repositories.UserRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MailService mailService;


    public ResponseEntity<User> save(UserDTO userDTO) {

        Optional<User> user = userRepository.findByUsername(userDTO.getUsername());
        if(user.isPresent()){
            return ResponseEntity.status(403).build();
        }
        User user2 = userRepository.findByEmail(userDTO.getEmail());
        User userToSave = new User();
        if(user2 != null){
            return ResponseEntity.status(403).build();
        }
        userDTO.setActivated(0);
        //userDTO.setPassword(new BCryptPasswordEncoder().encode(userDTO.getPassword()));
        BeanUtils.copyProperties(userDTO, userToSave);
        User created = userRepository.save(userToSave);
        mailService.sendVerificationEmail(created.getUsername(),created.getEmail());
        return ResponseEntity.ok(created);
    }

    public void delete(String id) {
        userRepository.deleteById(id);
    }

    public ResponseEntity<User> update(String username, UserDTO userDTO) {

        User user = requireOne(username);
        if(user.getEmail().equals(userDTO.getEmail())){
            userDTO.setActivated(1);
            User toSave = new User();
            BeanUtils.copyProperties(userDTO, toSave);
            System.out.println(toSave.getEmail());
            toSave.setUsername(username);
            User returned = userRepository.save(toSave);
            return ResponseEntity.ok(returned);
        }
        User mailUser = userRepository.findByEmail(userDTO.getEmail());
        if(mailUser != null){
            return ResponseEntity.status(403).build();
        }else{
            User updated = new User();
            userDTO.setActivated(1);
            BeanUtils.copyProperties(userDTO,updated);
            userRepository.save(updated);
            return ResponseEntity.ok(updated);
        }
    }

    public User requireOne(String username) {
        Optional<User> u = userRepository.findByUsername(username);
        if(u.isPresent()){
            User user = u.get();
            return user;
        }
        else return null;
    }

    public List<User> requireAll(){
        return userRepository.findAll();
    }

    public ResponseEntity<User> activate(String username){
        Optional<User> u = userRepository.findByUsername(username);
        if(u.isPresent()){
            User user = u.get();
            user.setActivated(1);
            userRepository.save(user);
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.status(404).build();
    }

    public ResponseEntity<User> login(LoginDTO loginDTO){
        Optional<User> u = userRepository.findByUsername(loginDTO.getUsername());
        if(u.isPresent()) {
            User user = u.get();
           //if( !passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())) {
               if (user.getPassword().equals(loginDTO.getPassword())) {
                   if (user.getActivated() == 1) {
                       return ResponseEntity.ok(user);
                   } else {
                       return ResponseEntity.status(403).build();
                   }
               }
           }
           return ResponseEntity.status(403).build();
       // }
        //return ResponseEntity.status(404).build();
    }
    public ResponseEntity<User> nonactive(LoginDTO loginDTO){
        Optional<User> u = userRepository.findByUsername(loginDTO.getUsername());
        if(u.isPresent()) {
            User user = u.get();
            if (user.getPassword().equals(loginDTO.getPassword())) {
                mailService.sendVerificationEmail(user.getUsername(),user.getEmail());
                return ResponseEntity.ok(user);
            }
        }
        return ResponseEntity.status(404).build();
    }
}
