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
        return "home_consell/anular_exito";
    }
    @RequestMapping(value="home_consell/activar_exito/{usuario}", method=RequestMethod.GET)
    public String confirmacionActivar(Model model, @PathVariable String usuario) {
        Estudiante estudianteEditado = estudianteDao.getEstudiante(usuario);
        estudianteEditado.setEstado("activo");
        estudianteDao.updateEstudiante(estudianteEditado);
        return "home_consell/activar_exito";
    }

    @RequestMapping("habilidad")
    public String formularioNuevaHabilidad(Model model) {
       model.addAttribute("nuevaHabilidad", new Habilidad());
       System.out.println("Dentro de formularioNuevaHabilidad");
        return "home_consell/habilidad";
    }

    @RequestMapping(value="home_consell/habilidad", method=RequestMethod.POST)
    public String addNuevaHabilidad(@ModelAttribute("nuevaHabilidad") Habilidad habilidad) {

        String id = java.util.UUID.randomUUID().toString().substring(1,4);
        System.out.println("creando nueva habilidad");
        habilidad.setId_hab(id);
        habilidad.setEstado("Activo");

        habilidadDao.addHabilidad(habilidad);
        return "habilidad_exito";
    }
}
