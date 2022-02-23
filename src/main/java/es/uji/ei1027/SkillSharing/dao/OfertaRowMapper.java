package es.uji.ei1027.SkillSharing.dao;

import es.uji.ei1027.SkillSharing.model.Oferta;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class OfertaRowMapper implements RowMapper<Oferta> {
    public Oferta mapRow(ResultSet rs, int rowNum) throws SQLException {
        Oferta oferta = new Oferta();
        oferta.setId_Oferta(rs.getString("id_oferta"));
        oferta.setFecha_Inicio(rs.getString("fecha_inicio"));
        oferta.setFecha_Fin(rs.getString("fecha_fin"));
        oferta.setDescripcion(rs.getString("descripcion"));
        oferta.setId_Habilidad(rs.getString("id_habilidad"));
        oferta.setId_Estudiante(rs.getString("id_estudiante"));
        return oferta;
    }
}
