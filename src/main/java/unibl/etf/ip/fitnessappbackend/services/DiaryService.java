package unibl.etf.ip.fitnessappbackend.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import unibl.etf.ip.fitnessappbackend.dtos.DiaryDTO;
import unibl.etf.ip.fitnessappbackend.models.Diary;
import unibl.etf.ip.fitnessappbackend.repositories.DiaryRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class DiaryService {

    @Autowired
    private DiaryRepository diaryRepository;

    public Integer save(String username) {
        System.out.println("SERVICE DIARY");
        Diary bean = new Diary();
        bean.setUsername(username);
        bean = diaryRepository.save(bean);
        return bean.getId();
    }

    public void delete(Integer id) {
        diaryRepository.deleteById(id);
    }

    public void update(Integer id, DiaryDTO diaryDTO) {
        Diary bean = requireOne(id);
        BeanUtils.copyProperties(diaryDTO, bean);
        diaryRepository.save(bean);
    }

    public DiaryDTO getById(Integer id) {
        Diary original = requireOne(id);
        return toDTO(original);
    }


    private DiaryDTO toDTO(Diary original) {
        DiaryDTO bean = new DiaryDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Diary requireOne(Integer id) {
        return diaryRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }

    public List<Diary> getAll(){
        return diaryRepository.findAll();
    }
    public boolean check(String username){
        Optional<Diary> diary = diaryRepository.findByUsername(username);
        if(diary.isPresent()){
            return true;
        }
        return false;
    }

    public Diary getByUsername(String username){
     Optional<Diary>  d =   diaryRepository.findByUsername(username);
     return d.get();
    }

}
