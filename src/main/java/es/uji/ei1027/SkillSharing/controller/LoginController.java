package es.uji.ei1027.SkillSharing.controller;


import javax.servlet.http.HttpSession;

import es.uji.ei1027.SkillSharing.dao.EstudianteDao;
import es.uji.ei1027.SkillSharing.model.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import es.uji.ei1027.SkillSharing.dao.UserDao;
import es.uji.ei1027.SkillSharing.model.UserDetails;

class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> cls) {
        return UserDetails.class.isAssignableFrom(cls);
    }
    @Override
    public void validate(Object obj, Errors errors) {
        // Exercici: Afegeix codi per comprovar que
        // l'usuari i la contrasenya no estiguen buits
        UserDetails user = (UserDetails) obj;
        if (user.getUsername().trim().equals("")) {
            errors.rejectValue("username", "obligatori",
                    "Cal introduir un valor");
        }
        if(user.getPassword().trim().equals("")) {
            errors.rejectValue("password", "obligatoria",
                    "Cal introduir un valor");
        }
    }
}

@Controller
public class LoginController {
    @Autowired
    private UserDao userDao;
    @Autowired
    private EstudianteDao estudianteDao;

    @RequestMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new UserDetails());
        return "login";
    }

    @RequestMapping("registrarse")
    public String registrarse(Model model) {
        model.addAttribute("nuevo_estudiante", new Estudiante());
        return "registrarse";
    }

    @RequestMapping(value="/registrarse", method= RequestMethod.POST)
    public String checkLogin(@ModelAttribute("nuevo_estudiante") Estudiante estudiante,
                             BindingResult bindingResult, HttpSession session) {

        //Comprobamos que id_estudiante no aparezca en la base de datos
        /*Estudiante registrado = estudianteDao.getEstudiante(estudiante.getId_estudiante());
        if (registrado == null){
            return "registrarse";
        }*/
        //Añadimos el estudiante a la base de datos
        estudiante.setId_estudiante(estudiante.getNombre_usuario());
        estudiante.setEmail(estudiante.getNombre_usuario() + "@uji.es");

        estudianteDao.addEstudiante(estudiante);

        // Torna a la pàgina principal
        return "registrarse_exito";
    }

    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String checkLogin(@ModelAttribute("user") UserDetails user,
                             BindingResult bindingResult, HttpSession session) {
        UserValidator userValidator = new UserValidator();
        userValidator.validate(user, bindingResult);
        if (bindingResult.hasErrors()) {
            return "login";
        }
        // Comprova que el login siga correcte
        // intentant carregar les dades de l'usuari
        user = userDao.loadUserByUsername(user.getUsername(), user.getPassword());
        if (user == null) {
            bindingResult.rejectValue("password", "badpw", "Contraseña incorrecta");
            return "login";
        }
        // Autenticats correctament.
        // Guardem les dades de l'usuari autenticat a la sessió
        session.setAttribute("user", user);
        return "inicio_sesion_exito";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
