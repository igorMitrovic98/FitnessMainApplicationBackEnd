package unibl.etf.ip.fitnessappbackend.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import unibl.etf.ip.fitnessappbackend.dtos.QuestionDTO;
import unibl.etf.ip.fitnessappbackend.models.Question;
import unibl.etf.ip.fitnessappbackend.repositories.QuestionRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public Integer save(QuestionDTO questionDTO) {
        Question bean = new Question();
        BeanUtils.copyProperties(questionDTO, bean);
        bean = questionRepository.save(bean);
        return bean.getId();
    }

    public List<Question> getByProgramId(Integer id){
       return questionRepository.findAllByProgramId(id);
    }


    public QuestionDTO getById(Integer id,String id2,Integer id3) {
        Question original = requireOne(id,id2,id3);
        return toDTO(original);
    }

    private QuestionDTO toDTO(Question original) {
        QuestionDTO bean = new QuestionDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Question requireOne(Integer id, String id2,Integer id3) {
        return questionRepository.findByIdAndUsernameAndProgramId(id,id2,id3);
    }


}
