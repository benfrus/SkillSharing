package es.uji.ei1027.SkillSharing.dao;

import es.uji.ei1027.SkillSharing.model.Peticion;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;


public final class PeticionRowMapper implements RowMapper<Peticion> {
    public Peticion mapRow(ResultSet rs, int rowNum) throws SQLException {
        Peticion peticion = new Peticion();
        peticion.setId_Pet(rs.getString("id_peticion"));
        peticion.setFecha_Inicio(rs.getString("fecha_inicio"));
        peticion.setFecha_Fin(rs.getString("fecha_fin"));
        peticion.setDescripcion(rs.getString("descripcion"));
        peticion.setId_Habilidad(rs.getString("id_habilidad"));
        peticion.setId_Estudiante(rs.getString("id_estudiante"));
        return peticion;
    }

}

