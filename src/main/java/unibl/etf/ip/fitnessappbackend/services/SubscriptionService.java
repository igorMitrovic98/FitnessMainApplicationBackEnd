package unibl.etf.ip.fitnessappbackend.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import unibl.etf.ip.fitnessappbackend.dtos.SubscriptionDTO;
import unibl.etf.ip.fitnessappbackend.models.Subscription;
import unibl.etf.ip.fitnessappbackend.repositories.SubscriptionRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class SubscriptionService {

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    public String save(SubscriptionDTO subscriptionDTO) {
        Subscription bean = new Subscription();
        BeanUtils.copyProperties(subscriptionDTO, bean);
        bean = subscriptionRepository.save(bean);
        return bean.getUsername();
    }

    public void delete(String id,String id2) {
        subscriptionRepository.deleteByUsernameAndCategoryName(id,id2);
    }


    public SubscriptionDTO getById(String id,String id2) {
        Subscription original = requireOne(id,id2);
        return toDTO(original);
    }

    private SubscriptionDTO toDTO(Subscription original) {
        SubscriptionDTO bean = new SubscriptionDTO();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Subscription requireOne(String id,String id2) {
        return subscriptionRepository.findByUsernameAndCategoryName(id,id2);
    }

    public List<Subscription> getAll(String username){

        return subscriptionRepository.findAllByUsername(username);
    }
}
