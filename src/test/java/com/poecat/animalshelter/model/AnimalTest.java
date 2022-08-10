package com.poecat.animalshelter.model;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class AnimalTest {

    @Test
    public void shouldGetPhotosPath() throws ParseException {

        //given
        String photoPath;
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date date = simpleDateFormat.parse("2022-06-22");

        Animal animal = new Animal(1, "Maisie", "dog", "female", date, "12",
                "Short description", Vaccinated.YES, Sterilized.YES, "photo.png" );

        //when
        photoPath = animal.getPhotosImagePath();

        //then
        assertThat(photoPath, containsString("photo.png"));
        assertThat(photoPath, containsString("/animal-photos/"));
    }

    @Test
    public void shouldBeEmptyIfCanNotGetPhotoPath() {

        //given
        String photoPath;
        Animal animal = new Animal();

        //when
        photoPath = animal.getPhotosImagePath();

        //then
        assertThat(photoPath, is(nullValue()));
    }
}
