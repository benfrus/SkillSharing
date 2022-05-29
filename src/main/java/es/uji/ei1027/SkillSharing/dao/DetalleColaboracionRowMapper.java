package es.uji.ei1027.SkillSharing.dao;

import es.uji.ei1027.SkillSharing.model.Colaboracion;
import es.uji.ei1027.SkillSharing.model.DetalleColaboracion;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class DetalleColaboracionRowMapper implements RowMapper<DetalleColaboracion> {
    public DetalleColaboracion mapRow(ResultSet rs, int rowNum) throws SQLException {

        DetalleColaboracion colaboracion = new DetalleColaboracion();
        colaboracion.setIdColaboracion(rs.getString("id_colab"));
        colaboracion.setEstudianteOferta(rs.getString("e_oferta"));
        colaboracion.setIdEstudianteOferta(rs.getString("id_e_oferta"));
        colaboracion.setIdOferta(rs.getString("id_oferta"));
        colaboracion.setDescripcionOferta(rs.getString("desc_oferta"));
        colaboracion.setEstudiantePeticion(rs.getString("e_peticion"));
        colaboracion.setIdEstudiantePeticion(rs.getString("id_e_peticion"));
        colaboracion.setIdPeticion(rs.getString("id_pet"));
        colaboracion.setDescripcionPeticion(rs.getString("desc_peticion"));
        colaboracion.setNombreHabilidad(rs.getString("n_habilidad"));

    return colaboracion;

    }
}
