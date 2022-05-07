package es.uji.ei1027.SkillSharing.dao;


import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.uji.ei1027.SkillSharing.model.Colaboracion;
import es.uji.ei1027.SkillSharing.model.Estudiante;
import org.jasypt.util.password.BasicPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import es.uji.ei1027.SkillSharing.model.UserDetails;

@Repository
public class UserProvider implements UserDao {
    final Map<String, UserDetails> knownUsers = new HashMap<String, UserDetails>();
    @Autowired
    EstudianteDao estudianteDao;
    public UserProvider() {
        BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
        UserDetails userAlice = new UserDetails();
        userAlice.setUsername("alice");
        userAlice.setPassword(passwordEncryptor.encryptPassword("alice"));
        knownUsers.put("alice", userAlice);

        UserDetails userBob = new UserDetails();
        userBob.setUsername("bob");
        userBob.setPassword(passwordEncryptor.encryptPassword("bob"));
        knownUsers.put("bob", userBob);
    }

    @Override
    public UserDetails loadUserByUsername(String username, String password) {
        System.out.println("entro en UserPorvider");
        Estudiante estudiante = estudianteDao.getEstudiante(username);
        System.out.println(estudiante.toString());
        UserDetails user = new UserDetails();
        user.setUsername(estudiante.getNombre_usuario());
        user.setPassword(estudiante.getContraseña());
        if (user == null)
            return null; // Usuario no existe
        // Contrasenya
        //BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
        System.out.println("la contraseña introducida es: " + password);
        System.out.println("la contraseña del usuario es: " + user.getPassword());
        if (password.equals(user.getPassword())) {

            // Es deuria esborrar de manera segura el camp password abans de tornar-lo
            return user;
        }
        else {
            return null; // bad login!
        }
       /* UserDetails user = knownUsers.get(username.trim());
        if (user == null)
            return null; // Usuari no trobat
        // Contrasenya
        BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
        if (passwordEncryptor.checkPassword(password, user.getPassword())) {
            // Es deuria esborrar de manera segura el camp password abans de tornar-lo
            return user;
        }
        else {
            return null; // bad login!
        }*/

    }

    @Override
    public Collection<UserDetails> listAllUsers() {
        //return estudianteDao.getEstudiantes();
        return knownUsers.values();
    }
}