package es.uji.ei1027.SkillSharing.controller;

import es.uji.ei1027.SkillSharing.dao.ColaboracionDao;
import es.uji.ei1027.SkillSharing.dao.HabilidadDao;
import es.uji.ei1027.SkillSharing.model.Colaboracion;
import es.uji.ei1027.SkillSharing.model.Habilidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/colaboracion")
public class ControladorColaboracion {

    @Autowired
    private ColaboracionDao colaboracionDao;

    public void setColaboracionDao(ColaboracionDao colaboracionDao){
        this.colaboracionDao = colaboracionDao;
    }

    // Obtener lista de un colaborador
    @RequestMapping("/lista")
    public String listaColaboraciones(Model model) {
        model.addAttribute("colaboraciones", colaboracionDao.getColaboraciones());
        return "colaboracion/lista";
    }

}

