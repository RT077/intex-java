package com.intexbox.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String homePage() {
        // This method returns the name of the view to be rendered.
        // Spring Boot's default configuration will look for a file named
        // 'index.html' in the 'static' or 'templates' directory.
    	 return "redirect:/index.html";
    }
}
