package es.uji.ei1027.SkillSharing.controller;

import es.uji.ei1027.SkillSharing.dao.ColaboracionDao;
import es.uji.ei1027.SkillSharing.dao.EstudianteDao;
import es.uji.ei1027.SkillSharing.dao.HabilidadDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home_consell")
public class ControladorConsell {

    @Autowired
    EstudianteDao estudianteDao;
    @Autowired
    HabilidadDao habilidadDao;

    @RequestMapping("/lista")
    public String GetListaEstudantes(Model model) {
        return "home_consell/lista";
    }
}
