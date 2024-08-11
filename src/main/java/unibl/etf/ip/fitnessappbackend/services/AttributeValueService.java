package unibl.etf.ip.fitnessappbackend.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import unibl.etf.ip.fitnessappbackend.dtos.AttributeValueDTO;
import unibl.etf.ip.fitnessappbackend.models.AttributeValue;
import unibl.etf.ip.fitnessappbackend.repositories.AttributeValueRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AttributeValueService {

    @Autowired
    private AttributeValueRepository attributeValueRepository;

    public String save(AttributeValueDTO attributeValueDTO) {
        AttributeValue bean = new AttributeValue();
        BeanUtils.copyProperties(attributeValueDTO, bean);
        bean = attributeValueRepository.save(bean);
        return bean.getProgramId().toString();
    }

    public void delete(Integer id,String id2) {
        attributeValueRepository.deleteByProgramIdAndAttributeName(id,id2);
    }

    public List<AttributeValue> getForProgram(Integer id){
        return attributeValueRepository.findAllByProgramId(id);
    }
}
