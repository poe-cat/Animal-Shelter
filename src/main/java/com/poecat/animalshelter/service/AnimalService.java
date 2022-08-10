package com.poecat.animalshelter.service;

import com.poecat.animalshelter.exceptions.AnimalNotFoundException;
import com.poecat.animalshelter.model.Animal;
import com.poecat.animalshelter.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    public AnimalService() {
    }

    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public Animal get(Integer animalId) throws AnimalNotFoundException {

        Optional<Animal> animalOptional = animalRepository.findById(animalId);

        if (animalOptional.isPresent()) {
            return animalOptional.get();
        }
        throw new AnimalNotFoundException("Couldn't find any animal with ID " + animalId);
    }

    public void delete(Integer animalId) throws AnimalNotFoundException {

        animalRepository.deleteById(animalId);
    }

    public List<Animal> search(String keyword) {
        return animalRepository.search(keyword);
    }
}
