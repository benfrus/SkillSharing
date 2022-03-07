package es.uji.ei1027.SkillSharing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class prueba {
    @RequestMapping("/prueba")
    public String provaWeb(Model model) {
        String message = "Provant la Web del Club Esportiu";
        model.addAttribute("message", message);
        return "prueba";
    }
}

