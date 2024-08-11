package unibl.etf.ip.fitnessappbackend.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import unibl.etf.ip.fitnessappbackend.dtos.LocationDTO;
import unibl.etf.ip.fitnessappbackend.models.Location;
import unibl.etf.ip.fitnessappbackend.repositories.LocationRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;



    public Location getById(Integer id) {
        return requireOne(id);

    }

    private Location requireOne(Integer id) {
        return locationRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }

    public List<Location> getAll(){
        return locationRepository.findAll();
    }
}
