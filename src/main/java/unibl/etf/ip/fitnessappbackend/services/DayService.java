package unibl.etf.ip.fitnessappbackend.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import unibl.etf.ip.fitnessappbackend.dtos.DayDTO;
import unibl.etf.ip.fitnessappbackend.models.Day;
import unibl.etf.ip.fitnessappbackend.repositories.DayRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class DayService {

    @Autowired
    private DayRepository dayRepository;

    public String save(DayDTO dayDTO) {
        Day bean = new Day();
        BeanUtils.copyProperties(dayDTO, bean);
        bean = dayRepository.save(bean);
        return bean.getDate().toString();
    }

    public void delete(Date id, Integer id2) {
        dayRepository.deleteByDateAndDiaryId(id,id2);
    }

    public void update(Date id,Integer id2, DayDTO dayDTO) {
        Day bean = requireOne(id,id2);
        BeanUtils.copyProperties(dayDTO, bean);
        dayRepository.save(bean);
    }

    public DayDTO getById(Date id,Integer id2) {
        Day original = requireOne(id,id2);
        return toDTO(original);
    }

    private DayDTO toDTO(Day original) {
        DayDTO bean = new DayDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Day requireOne(Date id,Integer id2) {
        return dayRepository.findByDateAndDiaryId(id,id2);
    }

    public List<Day> getAll(){
        return dayRepository.findAll();
    }

    public List<Day> getDaysByDiaryId(Integer diaryId){
        return dayRepository.findAllByDiaryId(diaryId);
    }

    public boolean checkDay(Integer diaryId){
        java.sql.Date date = java.sql.Date.valueOf(LocalDate.now());
        System.out.println(date);
        Day day = dayRepository.findByDateAndDiaryId(date,diaryId);
        if(day != null){
            return true;
        }
        return false;
    }
}
