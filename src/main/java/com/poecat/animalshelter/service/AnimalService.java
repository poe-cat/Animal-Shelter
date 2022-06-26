package com.poecat.animalshelter.service;

import com.poecat.animalshelter.exceptions.AnimalNotFoundException;
import com.poecat.animalshelter.model.Animal;
import com.poecat.animalshelter.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    public Animal get(Integer animalId) throws AnimalNotFoundException {

        Optional<Animal> animalOptional = animalRepository.findById(animalId);

        if (animalOptional.isPresent()) {
            return animalOptional.get();
        }
        throw new AnimalNotFoundException("Couldn't find any commission with ID " + animalId);
    }

//    public void delete(Integer id) throws CommissionNotFoundException {
//        Long count = repository.countById(id);
//        if(count == null || count == 0) {
//            throw new CommissionNotFoundException("Couldn't find any commission with ID " + id);
//        }
//        repository.deleteById(id);
//    }
}
