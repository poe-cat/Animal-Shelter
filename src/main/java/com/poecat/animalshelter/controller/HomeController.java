package com.poecat.animalshelter.controller;

import com.poecat.animalshelter.FileUploadUtil;
import com.poecat.animalshelter.exceptions.AnimalNotFoundException;
import com.poecat.animalshelter.model.Animal;
import com.poecat.animalshelter.repository.AnimalRepository;
import com.poecat.animalshelter.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private AnimalRepository animalRepository;
    @Autowired
    private AnimalService animalService;

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
    public String addNewBook(@ModelAttribute("animal") Animal animal,
                             @RequestParam("image") MultipartFile multipartFile) throws IOException {

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        animal.setPhotos(fileName);

        animalRepository.save(animal);

        String uploadDir = "./animal-photos/" + animal.getAnimalId();

        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);


        return "redirect:/";
    }

    @RequestMapping("/edit/{animalId}")
    public String editAnimal(@PathVariable(name = "animalId") Integer animalId,
                                         Model model, RedirectAttributes re) {

        try {
            Animal animal = animalService.get(animalId);
            model.addAttribute("animal", animal);
            model.addAttribute("pageTitle", "Edit commission (ID: " + animalId + ")");

            return "editAnimal";

        } catch (AnimalNotFoundException e) {
            re.addFlashAttribute("message", e.getMessage());

            return "redirect:/";
        }
    }


}


