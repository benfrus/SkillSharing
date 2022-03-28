package es.uji.ei1027.SkillSharing.controller;

import es.uji.ei1027.SkillSharing.dao.HabilidadDao;
import es.uji.ei1027.SkillSharing.model.Habilidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
public class ControladorHabilidad {

    @Autowired
    HabilidadDao habilidadDao;

    @RequestMapping("/prova")
    public String provaWeb(Model model) {
        //Habilidad habilidad = habilidadDao.getHabilidad("1");
        String message = "Provant la Web del Club Esportiu";
        String habilidad = "paco";
        model.addAttribute("message", message);
        return "prova";
    }

}

