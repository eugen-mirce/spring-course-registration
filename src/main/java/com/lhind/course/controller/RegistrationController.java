package com.lhind.course.controller;

import com.lhind.course.model.entity.Registration;
import com.lhind.course.service.RegistrationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/registrations")
public class RegistrationController {
    private RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping
    public String getRegistrations(Model model) {
        List<Registration> registrations = registrationService.findAll();
        model.addAttribute("registrations",registrations);

        return "registrations";
    }
}
