package es.uji.ei1027.SkillSharing.controller;

import es.uji.ei1027.SkillSharing.dao.ColaboracionDao;
import es.uji.ei1027.SkillSharing.dao.EstudianteDao;
import es.uji.ei1027.SkillSharing.dao.HabilidadDao;
import es.uji.ei1027.SkillSharing.model.Estudiante;
import es.uji.ei1027.SkillSharing.model.Habilidad;
import es.uji.ei1027.SkillSharing.model.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("home_consell")
public class ControladorConsell {

    @Autowired
    EstudianteDao estudianteDao;
    @Autowired
    HabilidadDao habilidadDao;

    @RequestMapping("/lista")
    public String GetListaEstudantes(Model model, HttpSession session) {

        Object sesion = session.getAttribute("user");

        UserDetails userDetails = (UserDetails)sesion;
        model.addAttribute("estudiante", estudianteDao.getEstudiante(userDetails.getUsername()));
        model.addAttribute("todos_estudiantes", estudianteDao.getEstudiantes());
        model.addAttribute("habilidades", habilidadDao.getHabillidades());

        return "home_consell/lista";
    }

    // USUARIO
    @RequestMapping(value="home_consell/anular/{usuario}", method=RequestMethod.GET)
    public String anularEstudiante(Model model, @PathVariable String usuario){
        model.addAttribute("usuario_anulado", usuario);
        return "home_consell/confirmacion_anular";
    }

    @RequestMapping(value="home_consell/activar/{usuario}", method=RequestMethod.GET)
    public String activarEstudiante(Model model, @PathVariable String usuario){
        System.out.println("en activar usuario");
        model.addAttribute("usuario_activado", usuario);
        return "home_consell/confirmacion_activar";
    }

    @RequestMapping(value="home_consell/anular_exito/{usuario}", method=RequestMethod.GET)
    public String confirmacionAnular(Model model, @PathVariable String usuario) {
        Estudiante estudianteEditado = estudianteDao.getEstudiante(usuario);
        estudianteEditado.setEstado("anulado");
        estudianteDao.updateEstudiante(estudianteEditado);

        //TODO: ANULAR TODAS LAS OFERTAS Y PETICIONES DEL ESTUDIANTE
        return "home_consell/anular_exito";
    }
    @RequestMapping(value="home_consell/activar_exito/{usuario}", method=RequestMethod.GET)
    public String confirmacionActivar(Model model, @PathVariable String usuario) {
        Estudiante estudianteEditado = estudianteDao.getEstudiante(usuario);
        estudianteEditado.setEstado("activo");
        estudianteDao.updateEstudiante(estudianteEditado);
        return "home_consell/activar_exito";
    }

    // HABILIDAD
    @RequestMapping("habilidad")
    public String formularioNuevaHabilidad(Model model) {
       model.addAttribute("nuevaHabilidad", new Habilidad());
       System.out.println("Dentro de formularioNuevaHabilidad");
        return "home_consell/habilidad";
    }

    @RequestMapping(value="home_consell/habilidad", method=RequestMethod.POST)
    public String addNuevaHabilidad(@ModelAttribute("nuevaHabilidad") Habilidad habilidad) {

        String id = java.util.UUID.randomUUID().toString().substring(1,4);
        habilidad.setId_hab(id);
        habilidad.setEstado("Activo");

        habilidadDao.addHabilidad(habilidad);
        return "habilidad_exito";
    }
    @RequestMapping(value="home_consell/anular_habilidad/{id_hab}", method=RequestMethod.GET)
    public String anularHabilidad(Model model, @PathVariable String id_hab){
        Habilidad habilidad_anular= habilidadDao.getHabilidad(id_hab);
        model.addAttribute("habilidad_anulada", habilidad_anular.getNombre());
        model.addAttribute("id_habilidad",id_hab);
        return "home_consell/confirmacion_anular_habilidad";
    }
    @RequestMapping(value="home_consell/anular_exito_habilidad/{id_hab}", method=RequestMethod.GET)
    public String confirmacionAnularHabilidad(Model model, @PathVariable String id_hab) {
        Habilidad habilidadEditada=habilidadDao.getHabilidad(id_hab);
        habilidadEditada.setEstado("Cancelado");
        habilidadDao.updateHabilidad(habilidadEditada);

        //TODO: ANULAR TODAS LAS OFERTAS Y PETICIONES DE ESA HABILIDAD
        return "home_consell/anular_exito_habilidad";
    }
    @RequestMapping(value="home_consell/activar_habilidad/{id_hab}", method=RequestMethod.GET)
    public String activaHabilidad(Model model, @PathVariable String id_hab){
        Habilidad habilidad_activar= habilidadDao.getHabilidad(id_hab);
        model.addAttribute("habilidad_anulada", habilidad_activar.getNombre());
        model.addAttribute("id_habilidad",id_hab);
        return "home_consell/confirmacion_activar_habilidad";
    }
    @RequestMapping(value="home_consell/activar_exito_habilidad/{id_hab}", method=RequestMethod.GET)
    public String confirmacionActivarHabilidad(Model model, @PathVariable String id_hab) {
        Habilidad habilidadEditada=habilidadDao.getHabilidad(id_hab);
        System.out.println(habilidadEditada.toString());
        habilidadEditada.setEstado("Activo");
        habilidadDao.updateHabilidad(habilidadEditada);
        return "home_consell/activar_exito_habilidad";
    }
    @RequestMapping(value="home_consell/modificar_habilidad/{id_hab}", method=RequestMethod.GET)
    public String modificar_Habilidad(Model model, @PathVariable String id_hab) {
        System.out.println("Entro aqui atontao");
        Habilidad habilidadAEditar=habilidadDao.getHabilidad(id_hab);
        model.addAttribute("habilidad_a_editar",habilidadAEditar);
        return "home_consell/modificar_habilidad";
    }

    //TODO: ACTUALIZAR UNA HABILIDAD
    @RequestMapping(value="home_consell/editar_habilidad/{id_hab}", method=RequestMethod.GET)
    public String editarHabilidad(@ModelAttribute("habilidad_a_editar") Habilidad habilidad_modificada, @PathVariable String id_hab) {
       //Habilidad viejaHabilidad = habilidadDao.getHabilidad(id_hab);
        //viejaHabilidad.setDescripcion(habilidad_modificada.getDescripcion());
        System.out.println(id_hab);
        //habilidadDao.updateHabilidad(viejaHabilidad);
        return "home_consell/confirmacion_editar_habilidad";
    }
}
