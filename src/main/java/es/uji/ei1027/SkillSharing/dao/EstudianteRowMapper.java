package es.uji.ei1027.SkillSharing.dao;

import es.uji.ei1027.SkillSharing.model.Estudiante;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class EstudianteRowMapper implements RowMapper<Estudiante> {
    public Estudiante mapRow(ResultSet rs, int rowNum) throws SQLException {
        Estudiante estudiante = new Estudiante();
        estudiante.setId_estudiante(rs.getString("id_estudiante"));
        estudiante.setNombre_usuario(rs.getString("nombre_usuario"));
        estudiante.setContraseña(rs.getString("contraseña"));
        estudiante.setNombre(rs.getString("nombre"));
        estudiante.setApellidos(rs.getString("apellidos"));
        estudiante.setEmail(rs.getString("email"));
        estudiante.setGrado(rs.getString("grado"));
        estudiante.setCurso(rs.getInt("curso"));
        estudiante.setRol(rs.getString("rol"));
        estudiante.setEstado(rs.getString("estado"));
        return estudiante;
    }
}


