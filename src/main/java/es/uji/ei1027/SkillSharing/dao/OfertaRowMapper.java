package es.uji.ei1027.SkillSharing.dao;

import es.uji.ei1027.SkillSharing.model.Oferta;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

public final class OfertaRowMapper implements RowMapper<Oferta> {
    public Oferta mapRow(ResultSet rs, int rowNum) throws SQLException {
        Oferta oferta = new Oferta();
        oferta.setId_oferta(rs.getString("id_oferta"));
        oferta.setFecha_Inicio(rs.getObject("fecha_inicio", LocalDate.class));
        oferta.setFecha_Fin(rs.getObject("fecha_fin", LocalDate.class));
        oferta.setDescripcion(rs.getString("descripcion"));
        oferta.setId_Habilidad(rs.getString("id_habilidad"));
        oferta.setId_Estudiante(rs.getString("id_estudiante"));
        oferta.setEstado(rs.getString("estado"));

        return oferta;
    }
}
