package es.uji.ei1027.SkillSharing.controller;

import es.uji.ei1027.SkillSharing.dao.*;
import es.uji.ei1027.SkillSharing.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpSession;

import java.net.http.HttpRequest;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
    @Autowired
    private HabilidadDao habilidadDao;

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
        model.addAttribute("habilidades", habilidadDao.getHabillidades());
        model.addAttribute("oferta", new OfertaFormulario());
        return "home_estudiante/oferta";
    }

    @RequestMapping(value="/oferta", method= RequestMethod.POST)
    public String addOferta(@ModelAttribute("oferta") OfertaFormulario ofertaFormulario,
                             BindingResult bindingResult, HttpSession session) {
        Oferta oferta = new Oferta();
        oferta.setId_oferta(java.util.UUID.randomUUID().toString());
        System.out.println("después de crear la oferta y ponerle el id");
        LocalDate ahora = java.time.LocalDate.now();
        oferta.setFecha_Inicio(ahora);

        System.out.println(oferta.toString());
        LocalDate fechaExpiracion = ahora.plusDays(ofertaFormulario.getMesesExpiracion()*30);
        oferta.setFecha_Fin(fechaExpiracion);

        String nombreHabilidad = ofertaFormulario.getHabilidad();
        oferta.setId_Habilidad(habilidadDao.getHabilidadByNombre(nombreHabilidad).getId_hab());

        oferta.setDescripcion(ofertaFormulario.getDescripcion());

        Object sesion = session.getAttribute("user");

        UserDetails userDetails = (UserDetails)sesion;
        oferta.setId_Estudiante(userDetails.getUsername());

        ofertaDao.addOferta(oferta);

        // Torna a la pàgina principal
        return "registrarse_exito";
    }

}