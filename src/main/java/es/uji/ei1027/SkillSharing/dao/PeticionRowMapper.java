package es.uji.ei1027.SkillSharing.dao;

import es.uji.ei1027.SkillSharing.model.Peticion;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;


public final class PeticionRowMapper implements RowMapper<Peticion> {
    public Peticion mapRow(ResultSet rs, int rowNum) throws SQLException {
        Peticion peticion = new Peticion();
        peticion.setId_Pet(rs.getString("id_pet"));
        peticion.setFecha_Inicio(rs.getObject("fecha_inicio", LocalDate.class));
        peticion.setFecha_Fin(rs.getObject("fecha_fin", LocalDate.class));
        peticion.setDescripcion(rs.getString("descripcion"));
        peticion.setId_Habilidad(rs.getString("id_habilidad"));
        peticion.setId_Estudiante(rs.getString("id_estudiante"));
        peticion.setEstado(rs.getString("estado"));
        return peticion;
    }

}

