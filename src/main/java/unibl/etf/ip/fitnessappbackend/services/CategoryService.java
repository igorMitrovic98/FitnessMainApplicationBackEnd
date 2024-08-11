package unibl.etf.ip.fitnessappbackend.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import unibl.etf.ip.fitnessappbackend.dtos.CategoryDTO;
import unibl.etf.ip.fitnessappbackend.models.Category;
import unibl.etf.ip.fitnessappbackend.repositories.CategoryRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;


    public List<Category> getAll(){
        return categoryRepository.findAll();
    }
}
