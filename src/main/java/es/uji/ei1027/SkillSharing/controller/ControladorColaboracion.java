package es.uji.ei1027.SkillSharing.controller;

import es.uji.ei1027.SkillSharing.dao.*;
import es.uji.ei1027.SkillSharing.model.Colaboracion;
import es.uji.ei1027.SkillSharing.model.Habilidad;
import es.uji.ei1027.SkillSharing.model.Oferta;
import es.uji.ei1027.SkillSharing.model.Peticion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/colaboracion")
public class ControladorColaboracion {

    @Autowired
    private ColaboracionDao colaboracionDao;
    @Autowired
    private EstudianteDao estudianteDao;
    @Autowired
    private OfertaDao ofertaDao;
    @Autowired
    private PeticionDao peticionDao;

    public void setColaboracionDao(ColaboracionDao colaboracionDao){
        this.colaboracionDao = colaboracionDao;
    }

    // Obtener lista de un colaborador
    @RequestMapping("/lista")
    public String listaColaboraciones(Model model) {
        model.addAttribute("colaboraciones", colaboracionDao.getColaboraciones());
        return "colaboracion/lista";
    }

    @RequestMapping("/colaboracion_pendiente/{id_oferta}/{id_peticion}")
    public String crearColaboracionPotencial(Model model, @PathVariable String id_oferta, @PathVariable String id_peticion ) {
        Oferta oferta = ofertaDao.getOferta(id_oferta);
        model.addAttribute("id_oferta", id_oferta);
        model.addAttribute("id_peticion", id_peticion);
        model.addAttribute("estudiante_colaborar", estudianteDao.getEstudiante(oferta.getId_Estudiante()));

        return "colaboracion/confirmacion_posible_colaboracion";
    }

    @RequestMapping("/exito_colaboracion_pendiente/{id_oferta}/{id_peticion}")
    public String crearColaboracion(@PathVariable String id_oferta, @PathVariable String id_peticion ) {

        Oferta oferta = ofertaDao.getOferta(id_oferta);
        oferta.setEstado("pendiente");
        ofertaDao.updateOferta(oferta);

        Peticion peticion = peticionDao.getPeticion(id_peticion);
        peticion.setEstado("pendiente");
        peticionDao.updatePeticion(peticion);

        Colaboracion posibleColaboracion = new Colaboracion();
        posibleColaboracion.setId_colab(java.util.UUID.randomUUID().toString().substring(1,8));
        posibleColaboracion.setId_oferta(id_oferta);
        posibleColaboracion.setId_pet(id_peticion);
        LocalDate ahora = java.time.LocalDate.now();
        posibleColaboracion.setFecha_inicio(ahora);
        posibleColaboracion.setEstado("pendiente");
        colaboracionDao.addColaboracion(posibleColaboracion);

        return "colaboracion/exito_posible_colaboracion";
    }

}

