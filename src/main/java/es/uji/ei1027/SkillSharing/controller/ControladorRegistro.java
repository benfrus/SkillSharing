package es.uji.ei1027.SkillSharing.controller;

import es.uji.ei1027.SkillSharing.dao.EstudianteDao;
import es.uji.ei1027.SkillSharing.model.Estudiante;
import es.uji.ei1027.SkillSharing.model.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

public class ControladorRegistro {

    @Autowired
    private EstudianteDao estudianteDao;

    /*@RequestMapping("/registrarse")
    public String registrarse(Model model) {
        //model.addAttribute("alumno", new Estudiante());
        return "registrarse";
    }*/

    @RequestMapping(value="/signin", method= RequestMethod.POST)
    public String checkLogin(@ModelAttribute("alumno") Estudiante estudiante,
                             BindingResult bindingResult, HttpSession session) {

        //Comprobamos que id_estudiante no aparezca en la base de datos
        Estudiante registrado = estudianteDao.getEstudiante(estudiante.getId_estudiante());
        if (registrado == null){
            return "signin";
        }
        //Añadimos el estudiante a la base de datos
        estudianteDao.addEstudiante(estudiante);

        // Torna a la pàgina principal
        return "redirect:/";
    }
}
