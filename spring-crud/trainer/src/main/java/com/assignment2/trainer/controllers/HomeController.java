/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assignment2.trainer.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Μ
 */
@Controller
public class HomeController {
    
    @GetMapping({"/", "/home"}) 
    public String home() { // http://localhost:8080/
        return "home";
    }
}
