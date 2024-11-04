package com.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/home")
    public String home(Model model) {
        System.out.println("Home page Handler");

        // Sending data to view
        model.addAttribute("name", "subString Technology");
        model.addAttribute("youTube", "TechLearn");
        model.addAttribute("gitHubRepo", "https://github.com/ritik6207");
        return "Home";
    }
}
