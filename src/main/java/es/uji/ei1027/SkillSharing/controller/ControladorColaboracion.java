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
        model.addAttribute("colaboraciones", colaboracionDao.getDetalleColaboraciones());
        return "colaboracion/lista";
    }
    // cuando el usuario de la petición quiere colaborar con una oferta
    @RequestMapping("/colaboracion_pendiente_peticion/{id_oferta}/{id_peticion}")
    public String crearColaboracionPotencialDetallePeticion(Model model, @PathVariable String id_oferta, @PathVariable String id_peticion ) {
        Oferta oferta = ofertaDao.getOferta(id_oferta);
        model.addAttribute("id_oferta", id_oferta);
        model.addAttribute("id_peticion", id_peticion);
        model.addAttribute("estudiante_colaborar", estudianteDao.getEstudiante(oferta.getId_Estudiante()));

        return "colaboracion/confirmacion_posible_colaboracion_peticion";
    }
    // cuando el usuario de la oferta quiere colaborar con una peticion
    @RequestMapping("/colaboracion_pendiente_oferta/{id_oferta}/{id_peticion}")
    public String crearColaboracionPotencialDetalleOferta(Model model, @PathVariable String id_oferta, @PathVariable String id_peticion ) {
        Peticion peticion = peticionDao.getPeticion(id_peticion);
        model.addAttribute("id_oferta", id_oferta);
        model.addAttribute("id_peticion", id_peticion);
        model.addAttribute("estudiante_colaborar", estudianteDao.getEstudiante(peticion.getId_Estudiante()));

        return "colaboracion/confirmacion_posible_colaboracion_oferta";
    }

    @RequestMapping("/exito_colaboracion_pendiente_oferta/{id_oferta}/{id_peticion}")
    public String crearColaboracionOferta(@PathVariable String id_oferta, @PathVariable String id_peticion ) {

        Oferta oferta = ofertaDao.getOferta(id_oferta);
        oferta.setEstado("esperando");
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
    @RequestMapping("/exito_colaboracion_pendiente_peticion/{id_oferta}/{id_peticion}")
    public String crearColaboracionPeticion(@PathVariable String id_oferta, @PathVariable String id_peticion ) {

        Oferta oferta = ofertaDao.getOferta(id_oferta);
        oferta.setEstado("pendiente");
        ofertaDao.updateOferta(oferta);

        Peticion peticion = peticionDao.getPeticion(id_peticion);
        peticion.setEstado("esperando");
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

    @RequestMapping("/aceptar_colaboracion/{id_oferta}/{id_peticion}/{id_colab}/{id_usuario}")
    public String aceptarColaboracion(Model model, @PathVariable String id_oferta, @PathVariable String id_peticion, @PathVariable String id_colab, @PathVariable String id_usuario) {

        model.addAttribute("id_usuario", id_usuario);

        Oferta oferta = ofertaDao.getOferta(id_oferta);
        oferta.setEstado("colaborando");
        ofertaDao.updateOferta(oferta);

        Peticion peticion = peticionDao.getPeticion(id_peticion);
        peticion.setEstado("colaborando");
        peticionDao.updatePeticion(peticion);

        Colaboracion colaboracion = colaboracionDao.getColaboracion(id_colab);
        colaboracion.setEstado("colaborando");

        colaboracion.setFecha_inicio(java.time.LocalDate.now());
        colaboracion.setFecha_fin(oferta.getFecha_Fin());
        colaboracionDao.updateColaboracion(colaboracion);

        return "colaboracion/exito_colaboracion";
    }

    @RequestMapping("/rechazar_colaboracion/{id_oferta}/{id_peticion}/{id_colab}")
    public String rechazarColaboracion(@PathVariable String id_oferta, @PathVariable String id_peticion, @PathVariable String id_colab) {

        Oferta oferta = ofertaDao.getOferta(id_oferta);
        oferta.setEstado("activo");
        ofertaDao.updateOferta(oferta);

        Peticion peticion = peticionDao.getPeticion(id_peticion);
        peticion.setEstado("activo");
        peticionDao.updatePeticion(peticion);

        Colaboracion colaboracion = colaboracionDao.getColaboracion(id_colab);
        colaboracionDao.deleteColaboracion(colaboracion);

        return "colaboracion/rechazo_colaboracion";
    }

}

