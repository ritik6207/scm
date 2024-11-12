package com.scm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class PageController {

    @RequestMapping("/home")
    public String home(Model model) {
        System.out.println("Home page Handler");

        // Sending data to view
        model.addAttribute("name", "subString Technology");
        model.addAttribute("youTube", "TechLearn");
        model.addAttribute("gitHubRepo", "https://github.com/ritik6207");
        return "home";
    }


    // about page
    @RequestMapping("/about")
    public String aboutPage(Model model){
        model.addAttribute("isActive", false);
        System.out.println("About page loading..");
        return "about";
    }

    // services page
    @RequestMapping("/service")
    public String servicesPage(){
        System.out.println("Services page loading..");
        return "services";
    }

    // contact
    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }
    

    // login
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // register
    @GetMapping("/register")
    public String register() {
        return "register";
    }
}
