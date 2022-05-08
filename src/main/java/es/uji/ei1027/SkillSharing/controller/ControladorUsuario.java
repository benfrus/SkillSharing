package es.uji.ei1027.SkillSharing.controller;

import es.uji.ei1027.SkillSharing.dao.*;
import es.uji.ei1027.SkillSharing.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;
import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("home_estudiante")
public class ControladorUsuario {

    @Autowired
    private OfertaDao ofertaDao;
    @Autowired
    private PeticionDao peticionDao;
    @Autowired
    private EstudianteDao estudianteDao;

    @RequestMapping("/lista")
    public String getOfertas(Model model, HttpSession session) {

        Object sesion = session.getAttribute("user");

        UserDetails userDetails = (UserDetails)sesion;
        model.addAttribute("estudiante", estudianteDao.getEstudiante(userDetails.getUsername()));
        model.addAttribute("ofertas", ofertaDao.getOfertaByUser(userDetails.getUsername()));
        System.out.println("despues de pedir las ofertas");

        model.addAttribute("peticiones", peticionDao.getPeticionesByUser(userDetails.getUsername()));
        System.out.println("despues de pedir las peticiones");
        return "home_estudiante/lista";
    }

    @RequestMapping("/oferta")
    public String nuevaOferta(Model model) {
        return "home_estudiante/oferta";
    }

}