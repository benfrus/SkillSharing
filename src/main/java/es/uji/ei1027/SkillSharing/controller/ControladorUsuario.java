package es.uji.ei1027.SkillSharing.controller;

import es.uji.ei1027.SkillSharing.dao.ColaboracionDao;
import es.uji.ei1027.SkillSharing.dao.HabilidadDao;
import es.uji.ei1027.SkillSharing.dao.OfertaDao;
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

    @RequestMapping("/lista")
    public String getOfertas(Model model, HttpSession session) {
        System.out.println("en get ofertas del controlador");
        Object sesion = session.getAttribute("user");
        System.out.println("despues de coger user");
        UserDetails userDetails = (UserDetails)sesion;
        System.out.println("el usuario loggeado es: " + userDetails.getUsername());
        model.addAttribute("ofertas", ofertaDao.getOfertaByUser(userDetails.getUsername()));
        System.out.println("después de la peticion bbdd");
        return "home_estudiante/lista";
    }

}