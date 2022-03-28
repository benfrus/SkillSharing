package es.uji.ei1027.SkillSharing.dao;

import es.uji.ei1027.SkillSharing.model.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EstudianteDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /* Añadimos el estudiante a la BBDD */

    public void addEstudiante (Estudiante estudiante){
        jdbcTemplate.update("INSERT INTO Estudiante VALUES(?, ?, ?, ?, ?, ?, ?, ?)", estudiante.getId_estudiante(), estudiante.getNombre_usuario(), estudiante.getContraseña(), estudiante.getNombre(), estudiante.getApellidos(), estudiante.getEmail(), estudiante.getGrado(), estudiante.getGrado());
    }

    /* Eliminamos al estudiante de la BBDD */

    public void deleteEstudiante(Estudiante estudiante){
        jdbcTemplate.update ("DELETE FROM Estudiante WHERE id_estudiante= ?", estudiante.getId_estudiante());
    }

    /* Actualizar los datos del estudiante, excepto su id que es la clave primaria */

    public void updateEstudiante(Estudiante estudiante){
        jdbcTemplate.update("UPDATE Estudiante SET nombre_usuario= ?, contraseña= ?, nombre= ?, apellidos= ?, email= ?, grado= ?, curso= ?", estudiante.getNombre_usuario(), estudiante.getContraseña(), estudiante.getNombre(), estudiante.getApellidos(), estudiante.getEmail(), estudiante.getGrado(), estudiante.getCurso());
    }

    /* Devolver los datos de un estudiante a partir de su id. Devuelve nulo si no existe en la BBDD */
    public Estudiante getEstudiante (String id_estudiante){
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM Estudiante WHERE id_estudiante= ?", new EstudianteRowMapper(), id_estudiante);
        }catch(EmptyResultDataAccessException e) {
            return null;
        }
    }

    /* Devolver los datos de una serie de estudiantes a partir del grado que cursan */

    public List<Estudiante> getEstudiantesGrado(String grado){
        try{
            return jdbcTemplate.query("SELECT * FROM Estudiante WHERE grado= ?", new EstudianteRowMapper(), grado);
        }
         catch(EmptyResultDataAccessException e) {
            return new ArrayList<Estudiante>();
         }
    }

    /* Devolver los datos de todos los estudiantes */

    public List<Estudiante> getEstudiantes () {
        try{
            return  jdbcTemplate.query("SELECT * FROM Estudiante", new EstudianteRowMapper());

        } catch(EmptyResultDataAccessException e){
            return new ArrayList<Estudiante>();
        }
    }

}