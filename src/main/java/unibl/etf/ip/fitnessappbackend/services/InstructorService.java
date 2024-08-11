package unibl.etf.ip.fitnessappbackend.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import unibl.etf.ip.fitnessappbackend.dtos.InstructorDTO;
import unibl.etf.ip.fitnessappbackend.models.Instructor;
import unibl.etf.ip.fitnessappbackend.repositories.InstructorRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class InstructorService {

    @Autowired
    private InstructorRepository instructorRepository;



    public Instructor getById(Integer id) {
        return requireOne(id);
    }



    private Instructor requireOne(Integer id) {
        return instructorRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }

    public List<Instructor> getAll(){
        return instructorRepository.findAll();
    }
}
