package unibl.etf.ip.fitnessappbackend.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import unibl.etf.ip.fitnessappbackend.dtos.ReplyDTO;
import unibl.etf.ip.fitnessappbackend.models.Reply;
import unibl.etf.ip.fitnessappbackend.repositories.ReplyRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ReplyService {

    @Autowired
    private ReplyRepository replyRepository;

    public String save(ReplyDTO replyDTO) {
        Reply bean = new Reply();
        BeanUtils.copyProperties(replyDTO, bean);
        bean = replyRepository.save(bean);
        return bean.getQuestionId().toString();
    }

    public Reply getByQuestionId(Integer id){
        return replyRepository.findByQuestionId(id);
    }

    public ReplyDTO getById(Integer id,String id2) {
        Reply original = requireOne(id,id2);
        return toDTO(original);
    }

    private ReplyDTO toDTO(Reply original) {
        ReplyDTO bean = new ReplyDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Reply requireOne(Integer id,String id2) {
        return replyRepository.findByQuestionIdAndUsername(id,id2);
    }

}
