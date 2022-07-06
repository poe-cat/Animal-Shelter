package com.poecat.animalshelter.repository;

import com.poecat.animalshelter.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {

    @Query(value = "SELECT * FROM animal WHERE "
            + "MATCH (type, gender, description, age) "
            + "AGAINST (?1)", nativeQuery = true)
    public List<Animal> search(String keyword);

}
