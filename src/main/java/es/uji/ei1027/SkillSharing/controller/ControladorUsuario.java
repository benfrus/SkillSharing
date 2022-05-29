package es.uji.ei1027.SkillSharing.controller;

import es.uji.ei1027.SkillSharing.dao.*;
import es.uji.ei1027.SkillSharing.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

import java.time.LocalDate;
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
    @Autowired
    private ColaboracionDao colaboracionDao;

    @RequestMapping("/lista")
    public String getOfertas(Model model, HttpSession session) {

        Object sesion = session.getAttribute("user");

        UserDetails userDetails = (UserDetails)sesion;
        model.addAttribute("estudiante", estudianteDao.getEstudiante(userDetails.getUsername()));

        List<Oferta> ofertas = ofertaDao.getOfertaByUser(userDetails.getUsername());
        model.addAttribute("ofertas", ofertas);

        model.addAttribute("peticiones", peticionDao.getPeticionesByUser(userDetails.getUsername()));

        model.addAttribute("colaboraciones", colaboracionDao.getDetalleColaboracionByUsuario(userDetails.getUsername()));
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

        return "home_estudiante/oferta_peticion_exito";
    }

    //OFERTA
    @RequestMapping(value="home_estudiante/ver_oferta/{id_oferta}", method=RequestMethod.GET)
    public String verOferta(Model model, @PathVariable String id_oferta){
        Oferta ofertaSeleccionada = ofertaDao.getOferta(id_oferta);
        model.addAttribute("oferta_seleccionada", ofertaSeleccionada);
        model.addAttribute("habilidad", habilidadDao.getHabilidad(ofertaSeleccionada.getId_Habilidad()));
        model.addAttribute("peticiones", peticionDao.getPeticionesParaColaborar(ofertaSeleccionada.getId_Habilidad(), ofertaSeleccionada.getFecha_Fin(), ofertaSeleccionada.getId_Estudiante(), id_oferta));
        model.addAttribute("colaboraciones", colaboracionDao.getDetalleColaboracionByOferta(id_oferta));
        return "home_estudiante/oferta_detalle";
    }

    //PETICION
    @RequestMapping(value="home_estudiante/ver_peticion/{id_peticion}", method=RequestMethod.GET)
    public String verPeticion(Model model, @PathVariable String id_peticion){
        Peticion peticionSeleccionada = peticionDao.getPeticion(id_peticion);
        model.addAttribute("peticion_seleccionada", peticionSeleccionada);
        model.addAttribute("habilidad", habilidadDao.getHabilidad(peticionSeleccionada.getId_Habilidad()));
        model.addAttribute("ofertas", ofertaDao.getOfertasParaColaborar(peticionSeleccionada.getId_Habilidad(), peticionSeleccionada.getFecha_Fin(), peticionSeleccionada.getId_Estudiante(), id_peticion));
        model.addAttribute("colaboraciones", colaboracionDao.getDetalleColaboracionByPeticion(id_peticion));
        return "home_estudiante/peticion_detalle";
    }



}