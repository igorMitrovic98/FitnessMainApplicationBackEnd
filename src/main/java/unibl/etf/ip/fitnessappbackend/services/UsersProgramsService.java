package unibl.etf.ip.fitnessappbackend.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import unibl.etf.ip.fitnessappbackend.dtos.UsersProgramsDTO;
import unibl.etf.ip.fitnessappbackend.models.User;
import unibl.etf.ip.fitnessappbackend.models.UsersPrograms;
import unibl.etf.ip.fitnessappbackend.repositories.UsersProgramsRepository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UsersProgramsService {

    @Autowired
    private UsersProgramsRepository usersProgramsRepository;

    public String save(String payment,String username,Integer programId) {
        UsersPrograms usersPrograms = new UsersPrograms();
        usersPrograms.setProgramId(programId);
        usersPrograms.setUsername(username);
        usersPrograms.setPayment(payment);
        usersPrograms.setDate(Date.valueOf(LocalDate.now()));
        usersProgramsRepository.save(usersPrograms);
        return usersPrograms.getUsername();
    }

    public UsersProgramsDTO getById(String id,Integer id2) {
        UsersPrograms original = requireOne(id,id2);
        return toDTO(original);
    }


    private UsersProgramsDTO toDTO(UsersPrograms original) {
        UsersProgramsDTO bean = new UsersProgramsDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private UsersPrograms requireOne(String id,Integer id2) {
        return usersProgramsRepository.findByUsernameAndProgramId(id,id2);
    }


    public boolean getByUsernameAndProgramId(String username,Integer programId){
       UsersPrograms u = usersProgramsRepository.findByUsernameAndProgramId(username,programId);
        return u != null;
    }

    public List<UsersPrograms> getProgramIds(String username){
        return usersProgramsRepository.findAllByUsername(username);

    }

    public UsersPrograms getSingle(String username,Integer programid){
        return usersProgramsRepository.findByUsernameAndProgramId(username,programid);
    }
}
