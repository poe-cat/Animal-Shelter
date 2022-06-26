package com.poecat.animalshelter.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "animal")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer animalId;

    private String animalName;

    private String type;

    private String age;

    private Gender gender;

    @Lob
    private String description;

    private boolean vaccinated;

    private boolean sterilized;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date arrivingDate;

    @Column(nullable = true, length = 64)
    private String photos;


    public Animal() {}

    public Animal(int animalId, String animalName, String type, Gender gender, Date arrivingDate,
                  String age, String description, boolean vaccinated, boolean sterilized, String photos) {
        this.animalId = animalId;
        this.animalName = animalName;
        this.type = type;
        this.age = age;
        this.gender = gender;
        this.description = description;
        this.vaccinated = vaccinated;
        this.sterilized = sterilized;
        this.arrivingDate = arrivingDate;
        this.photos = photos;
    }

    @Transient
    public String getPhotosImagePath() {
        if (photos == null || animalId == null) return null;

        return "/animal-photos/" + animalId + "/" + photos;
    }

    public Integer getAnimalId() {
        return animalId;
    }

    public void setAnimalId(Integer animalId) {
        this.animalId = animalId;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isVaccinated() {
        return vaccinated;
    }

    public void setVaccinated(boolean vaccinated) {
        this.vaccinated = vaccinated;
    }

    public boolean isSterilized() {
        return sterilized;
    }

    public void setSterilized(boolean sterilized) {
        this.sterilized = sterilized;
    }

    public Date getArrivingDate() {
        return arrivingDate;
    }

    public void setArrivingDate(Date arrivingDate) {
        this.arrivingDate = arrivingDate;
    }

    public String getPhotos() {
        return photos;
    }

    public void setPhotos(String photos) {
        this.photos = photos;
    }
}
