package com.koval.HelperForCafe.controller;

import com.koval.HelperForCafe.dto.PersonDto;
import com.koval.HelperForCafe.entity.Person;
import com.koval.HelperForCafe.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Controller
public class SignInController {

    private final PersonRepository personRepository;

    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public String signIn(Model model) {
        model.addAttribute("personDto", new PersonDto());
        return "signin";
    }

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public String signInSubmit(@ModelAttribute(value = "personDto") PersonDto personDto) {
        System.out.println(personDto.getLogin());
        System.out.println(personDto.getPassword());
        return "redirect:/";
    }
}
