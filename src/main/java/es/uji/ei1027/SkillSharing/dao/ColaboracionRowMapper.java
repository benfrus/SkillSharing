package es.uji.ei1027.SkillSharing.dao;

import es.uji.ei1027.SkillSharing.model.Colaboracion;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

public class ColaboracionRowMapper implements RowMapper<Colaboracion> {
    public Colaboracion mapRow(ResultSet rs, int rowNum) throws SQLException {
        Colaboracion colaboracion = new Colaboracion();
        Time fi = rs.getTime("fecha_inicio");
        Time ff = rs.getTime("fecha_fin");
        colaboracion.setId_colab(rs.getString("id_colab"));
        colaboracion.setFecha_inicio(fi != null ? fi.toLocalTime() : null);
        colaboracion.setFecha_fin(ff != null ? ff.toLocalTime() : null);
        colaboracion.setHoras_totales(rs.getInt("horas_totales"));
        colaboracion.setEvaluacion(rs.getString("evaluacion"));
        colaboracion.setComenatio(rs.getString("comentario"));
        colaboracion.setId_oferta(rs.getString("id_oferta"));
        colaboracion.setId_pet(rs.getString("id_pet"));
        colaboracion.setEstado(rs.getString("estado"));

    return colaboracion;

    }
}
