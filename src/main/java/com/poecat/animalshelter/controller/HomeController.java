package com.poecat.animalshelter.controller;

import com.poecat.animalshelter.model.Animal;
import com.poecat.animalshelter.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private AnimalRepository animalRepository;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String homePage(Model model) {

        List<Animal> animalList = animalRepository.findAll();
        model.addAttribute("animalList", animalList);

        return "index";
    }

    @GetMapping("/animalForm")
    public String bookForm(Model model) {

        model.addAttribute("animal", new Animal());

        return "animalForm";
    }

    @RequestMapping(value = "/animalForm/newAnimal")
    public String addNewBook(@ModelAttribute("animal") Animal animal) {
        animalRepository.save(animal);

        return "redirect:/";
    }

}


