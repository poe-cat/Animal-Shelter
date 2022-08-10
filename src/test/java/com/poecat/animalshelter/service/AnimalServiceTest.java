package com.poecat.animalshelter.service;

import com.poecat.animalshelter.model.Animal;
import com.poecat.animalshelter.model.Sterilized;
import com.poecat.animalshelter.model.Vaccinated;
import com.poecat.animalshelter.repository.AnimalRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@MockitoSettings(strictness = Strictness.STRICT_STUBS)
@ExtendWith(MockitoExtension.class)
public class AnimalServiceTest {

    @InjectMocks
    private AnimalService animalService;

    private Animal animal1, animal2;

    @Test
    public void shouldGetAnimal() {

        //given
        List<Animal> animalList = prepareAnimalData();
        AnimalRepository animalRepository = mock(AnimalRepository.class);
        given(animalRepository.findAll()).willReturn(animalList);

        //when
        //then
        assertThat(animalRepository.findAll().size(), is(2));
    }

    private List<Animal> prepareAnimalData() {

        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date = null;

        try {
            date = simpleDateFormat.parse("2022-06-22");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        animal1 = new Animal(1, "Maisie", "dog", "female", date, "12",
                "Short description", Vaccinated.YES, Sterilized.YES, "photo.png" );
        animal2 = new Animal(2, "Roy", "turtle", "male", date, "3",
                "Short description", Vaccinated.YES, Sterilized.YES, "photo2.png" );

        return Arrays.asList(animal1, animal2);
    }
}
