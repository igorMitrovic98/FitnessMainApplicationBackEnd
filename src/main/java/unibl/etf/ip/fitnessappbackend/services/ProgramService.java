package unibl.etf.ip.fitnessappbackend.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import unibl.etf.ip.fitnessappbackend.dtos.ProgramDTO;
import unibl.etf.ip.fitnessappbackend.models.Program;
import unibl.etf.ip.fitnessappbackend.repositories.ProgramRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProgramService {

    @Autowired
    private ProgramRepository programRepository;

    public Program save(ProgramDTO programDTO) {
        Program bean = new Program();
        BeanUtils.copyProperties(programDTO, bean);

        bean = programRepository.save(bean);
        return bean;
    }

    public void delete(Integer id) {
        programRepository.deleteById(id);
    }

    public void update(Integer id, ProgramDTO programDTO) {
        Program bean = requireOne(id);
        BeanUtils.copyProperties(programDTO, bean);
        programRepository.save(bean);
    }

    public ProgramDTO getById(Integer id) {
        Program original = requireOne(id);
        return toDTO(original);
    }

    public Program getSingleProgram(Integer id){
        Optional<Program> p = programRepository.findById(id);
        if(p.isPresent()){
            return p.get();
        }
        return null;
    }


    private ProgramDTO toDTO(Program original) {
        ProgramDTO bean = new ProgramDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Program requireOne(Integer id) {
        return programRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }

    public List<Program> getAll(){
        return programRepository.findAll();
    }

    public List<Program> getByUsername(String username){
        return programRepository.findAllByUsername(username);
    }
    public Page<Program> getAllPaginator(Integer pageNo, Integer size, String sort){
        Pageable pageable = PageRequest.of(pageNo,size, Sort.by(sort));
        return programRepository.findAll(pageable);
    }
}
