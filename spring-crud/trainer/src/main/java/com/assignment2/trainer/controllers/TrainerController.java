/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment2.trainer.controllers;

import com.assignment2.trainer.entities.Trainer;
import com.assignment2.trainer.services.TrainerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Μ
 */
@Controller("trainers")
@RequestMapping("/trainers")
public class TrainerController {

    @Autowired
    private TrainerService service;

    @GetMapping("/")
    public String getAllTrainers(Model model) { //http:localhost:8080/trainers/
        List<Trainer> trainers = service.getAllTrainers();
        model.addAttribute("trainers", trainers);
        return ("trainers");
    }

    @GetMapping("/new")
    public String newTrainer(Model model) { //http:localhost:8080/trainers/new
        Trainer t = new Trainer();
        model.addAttribute("trainer", t);
        model.addAttribute("title", "New Trainer");
        model.addAttribute("h1", "Insert New Trainer");
        model.addAttribute("submit", "Add a New Trainer");
        model.addAttribute("action", "/trainers/new");

        return ("newEditTrainer");
    }

    @PostMapping("/new")
    public String insertTrainer(@ModelAttribute(name = "trainer") Trainer t, Model model) {

        if (service.insertTrainer(t)) {
            List<Trainer> trainers = service.getAllTrainers();
            model.addAttribute("trainers", trainers);
            return ("trainers");
        } else {
            return ("/");
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteTrainer(@PathVariable(name = "id") Integer id, Model model) {
        //1.findById
        //2.delete
        //3.findAll

        //addAttribute message an svistike
        if (service.findById(id)) {
            service.deleteById(id);
            List<Trainer> trainers = service.getAllTrainers();
            model.addAttribute("trainers", trainers);
            return ("trainers");
        } else {
            //forward/products
            return ("redirect:/trainers/");
        }
    }

    //GET edit
    @GetMapping("/edit/{id}")
    public String editTrainer(@PathVariable(name = "id") Integer id, Model model) {
        // findById
        // addAttribute
        // forward /edit
        Trainer t = service.getById(id);
        model.addAttribute("trainer", t);
        model.addAttribute("title", "Edit Trainer");
        model.addAttribute("h1", "Edit Trainer");
        model.addAttribute("action", "/trainers/update");
        model.addAttribute("submit", "Update Trainer");
        return ("newEditTrainer");
    }

    //GET or POST???
    @PostMapping("/update")
    public String updateTrainer(@ModelAttribute(name = "trainer") Trainer t, Model model) {
        service.updateTrainer(t);
        List<Trainer> trainers = service.getAllTrainers();
        model.addAttribute("trainers", trainers);
        return ("trainers");

    }
}
