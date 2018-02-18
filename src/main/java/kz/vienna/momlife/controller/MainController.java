package kz.vienna.momlife.controller;

import kz.vienna.momlife.model.entity.Patient;
import kz.vienna.momlife.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Autowired
    private PatientRepository patientRepository;


    @GetMapping("/")
    public String mainPage(Model model) {
        model.addAttribute("patient", new Patient());
        model.addAttribute("patientList", patientRepository.findAll());
        return "main";
    }
}