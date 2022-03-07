package es.uji.ei1027.SkillSharing.dao;


import es.uji.ei1027.SkillSharing.model.Habilidad;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class HabilidadRowMapper implements RowMapper<Habilidad> {
    public Habilidad mapRow(ResultSet rs, int rowNum) throws SQLException {
        Habilidad habilidad = new Habilidad();
        habilidad.setId_hab(rs.getString("id_habilidad"));
        habilidad.setNombre(rs.getString("nombre"));
        habilidad.setTipo(rs.getString("tipo"));
        habilidad.setNivel(rs.getString("nivel"));
        habilidad.setEstado(rs.getString("estado"));
        return habilidad;
    }
}
