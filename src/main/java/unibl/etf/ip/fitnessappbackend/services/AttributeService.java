package unibl.etf.ip.fitnessappbackend.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import unibl.etf.ip.fitnessappbackend.dtos.AttributeDTO;
import unibl.etf.ip.fitnessappbackend.models.Attribute;
import unibl.etf.ip.fitnessappbackend.repositories.AttributeRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AttributeService {

    @Autowired
    private AttributeRepository attributeRepository;

    public List<Attribute> getByCategoryName(String categoryName) {
        return attributeRepository.findAllByCategoryName(categoryName);
    }



    private Attribute requireOne(String id) {
        return attributeRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }

}
