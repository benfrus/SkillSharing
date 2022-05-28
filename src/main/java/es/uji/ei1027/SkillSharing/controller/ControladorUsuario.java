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

import javax.servlet.http.HttpSession;

import java.time.LocalDate;


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

        model.addAttribute("peticiones", peticionDao.getPeticionesByUser(userDetails.getUsername()));
        return "home_estudiante/lista";
    }

    @RequestMapping("/oferta_peticion")
    public String nuevaOferta(Model model) {
        model.addAttribute("habilidades", habilidadDao.getHabillidades());
        model.addAttribute("oferta_peticion", new OfertaPeticionFormulario());
        return "home_estudiante/oferta_peticion";
    }

    @RequestMapping("/pagina_principal")
    public String irPaginaPrincipal() {
        return "redirect:/";
    }

    @RequestMapping(value="home_estudiante/oferta_peticion", method= RequestMethod.POST)
    public String addOferta(@ModelAttribute("oferta_peticion") OfertaPeticionFormulario ofertaPeticionFormulario,
                             BindingResult bindingResult, HttpSession session) {

        // Crea una nueva oferta
        Oferta oferta = new Oferta();
        oferta.setId_oferta(java.util.UUID.randomUUID().toString().substring(1,4));

        LocalDate ahora = java.time.LocalDate.now();
        oferta.setFecha_Inicio(ahora);

        LocalDate fechaExpiracion = ahora.plusDays(ofertaPeticionFormulario.getMesesExpiracionOferta()*30);
        oferta.setFecha_Fin(fechaExpiracion);

        String nombreHabilidad = ofertaPeticionFormulario.getHabilidadOferta();
        oferta.setId_Habilidad(habilidadDao.getHabilidadByNombre(nombreHabilidad).getId_hab());

        oferta.setDescripcion(ofertaPeticionFormulario.getDescripcionOferta());

        Object sesion = session.getAttribute("user");

        UserDetails userDetails = (UserDetails)sesion;
        oferta.setId_Estudiante(userDetails.getUsername());
        oferta.setEstado("activo");
        System.out.println(oferta.toString());
        ofertaDao.addOferta(oferta);

        // Crea una nueva petición
        Peticion peticion = new Peticion();
        peticion.setId_Pet(java.util.UUID.randomUUID().toString().substring(1,4));

        peticion.setFecha_Inicio(ahora);
        peticion.setFecha_Fin(ahora.plusDays(ofertaPeticionFormulario.getMesesExpiracionOferta()*30));

        String nombreHabilidadPet = ofertaPeticionFormulario.getHabilidadPeticion();
        peticion.setId_Habilidad(habilidadDao.getHabilidadByNombre(nombreHabilidadPet).getId_hab());
        peticion.setDescripcion(ofertaPeticionFormulario.getDescripcionPeticion());

        peticion.setId_Estudiante(userDetails.getUsername());
        peticion.setEstado("activo");
        System.out.println(peticion.toString());
        peticionDao.addPeticion(peticion);


        // Torna a la pàgina principal
        return "home_estudiante/oferta_peticion_exito";
    }


}