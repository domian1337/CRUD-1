package com.example.controller;

import com.example.model.Person;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class PersonController {

    private final UserService us;

    @Autowired
    public PersonController(UserService us) {
        this.us = us;
    }

    @GetMapping("/users")
    public String showUsers(Model model) {
        model.addAttribute("users", us.findAll());
        return "users";
    }

    @GetMapping("/edit")
    public String editPage(Model model, @RequestParam int id) {
        model.addAttribute("user", us.findUserById(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String editPerson(@ModelAttribute("user") Person user ) {
        us.update(user);
        return "redirect:/users";
    }

    @GetMapping("/add")
    public String addPage(Model model) {
        model.addAttribute("user", new Person());
        return "add";
    }

    @PostMapping("/add")
    public String addPerson(@ModelAttribute("person") Person person) {
        us.add(person);
        return "redirect:/users";
    }

    @GetMapping("/delete")
    public String deletePerson(@RequestParam int id) {
        us.delete(id);
        return "redirect:/users";
    }
}
