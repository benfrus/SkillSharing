package es.uji.ei1027.SkillSharing.dao;

import es.uji.ei1027.SkillSharing.model.Colaboracion;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

public class ColaboracionRowMapper implements RowMapper<Colaboracion> {
    public Colaboracion mapRow(ResultSet rs, int rowNum) throws SQLException {

        Colaboracion colaboracion = new Colaboracion();
        colaboracion.setId_colab(rs.getString("id_colab"));
        colaboracion.setFecha_inicio(rs.getString("fecha_inicio"));
        colaboracion.setFecha_fin(rs.getString("fecha_fin"));
        colaboracion.setHoras_totales(rs.getInt("horas_totales"));
        colaboracion.setEvaluacion(rs.getString("evaluacion"));
        colaboracion.setComentario(rs.getString("comentario"));
        colaboracion.setId_oferta(rs.getString("id_oferta"));
        colaboracion.setId_pet(rs.getString("id_pet"));
        colaboracion.setEstado(rs.getString("estado"));

    return colaboracion;

    }
}
