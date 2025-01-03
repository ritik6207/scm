package com.scm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.entities.User;
import com.scm.forms.UserForm;
import com.scm.helpers.Message;
import com.scm.helpers.MessageType;
import com.scm.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class PageController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index(){
        return "redirect:/home";
    }

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
    public String aboutPage(Model model) {
        model.addAttribute("isActive", false);
        System.out.println("About page loading..");
        return "about";
    }

    // services page
    @RequestMapping("/service")
    public String servicesPage() {
        System.out.println("Services page loading..");
        return "services";
    }

    // contact
    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }

    // This is showing login page
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    //registration page
    @GetMapping("/register")
    public String register(Model model) {

        UserForm userForm = new UserForm();
        // ! We can insert default data in form
        // userForm.setName("Ritik");
        // userForm.setEmail("b4d0Z@example.com");
        // userForm.setPassword("123456");
        // userForm.setPhoneNumber("122344");
        // userForm.setAbout("I am a software developer");

        model.addAttribute("userForm", userForm);
        return "register";
    }

    // Processing Registration
    @RequestMapping(value = "/do-register", method = RequestMethod.POST)
    public String processRegister(@Valid @ModelAttribute UserForm userForm, BindingResult rBindingResult ,HttpSession session) {
        System.out.println("Processing Registration");
        // fetch from data
        // UserForm
        System.out.println(userForm);
        // validate from data
        if(rBindingResult.hasErrors()) {
            return "register";
        }
        // save to database

        // userservice
        // userForm--> User
        // User user = User.builder()
        //         .name(userForm.getName())
        //         .email(userForm.getEmail())
        //         .password(userForm.getPassword())
        //         .phoneNumber(userForm.getPhoneNumber())
        //         .about(userForm.getAbout())
        //         .profilePic(
        //                 "https://static.vecteezy.com/system/resources/thumbnails/009/734/564/small/default-avatar-profile-icon-of-social-media-user-vector.jpg")
        //         .build();

        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail()); 
        user.setPassword(userForm.getPassword());
        user.setAbout(userForm.getAbout());
        user.setPhoneNumber(userForm.getPhoneNumber());
        user.setProfilePic("https://static.vecteezy.com/system/resources/thumbnails/009/734/564/small/default-avatar-profile-icon-of-social-media-user-vector.jpg");

        User savedUser = userService.saveUser(user);

        System.out.println("User Saved");
        // message = "Registration Successful"
        //add the message
        Message message = Message.builder().content("Registration Successful").type(MessageType.green).build();
        session.setAttribute("message", message);
        // redirect login page
        return "redirect:/register";
    }
}
