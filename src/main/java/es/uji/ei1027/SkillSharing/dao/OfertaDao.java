package es.uji.ei1027.SkillSharing.dao;

import es.uji.ei1027.SkillSharing.model.Habilidad;
import es.uji.ei1027.SkillSharing.model.Oferta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OfertaDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /* Añadimos oferta a la BBDD */

    public void addOferta (Oferta oferta){
        jdbcTemplate.update("INSERT INTO oferta VALUES(?, ?, ?, ?, ?, ?)", oferta.getId_Oferta(), oferta.getFecha_Inicio(), oferta.getFecha_Fin(), oferta.getDescripcion(), oferta.getId_Habilidad(), oferta.getId_Estudiante());
    }

    /* Eliminamos la oferta de la BBDD */

    public void deleteOferta(Oferta oferta){
        jdbcTemplate.update ("DELETE FROM oferta WHERE id_oferta= ?", oferta.getId_Oferta());
    }

    /* Actualizar los datos de la habilidad */

    public void updateOferta(Oferta oferta){
        jdbcTemplate.update("UPDATE oferta SET id_oferta= ?,  fecha_inicio= ?, fecha_fin= ?, descripcion= ?, id_habilidad= ?, id_estudiante= ?", oferta.getId_Oferta(), oferta.getFecha_Inicio(), oferta.getFecha_Fin(), oferta.getDescripcion(), oferta.getId_Habilidad(), oferta.getId_Estudiante());
    }

    /* Devolver los datos de un estudiante a partir de su id. Devuelve nulo si no existe en la BBDD */
    public Oferta getOferta (String id_oferta){
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM oferta WHERE id_oferta= ?", new OfertaRowMapper(), id_oferta);
        }catch(EmptyResultDataAccessException e) {
            return null;
        }
    }

    /* Devolver los datos de una serie de estudiantes a partir del grado que cursan */

    public List<Oferta> getOfertas(){
        try{
            return jdbcTemplate.query("SELECT * FROM oferta ", new OfertaRowMapper());
        }
        catch(EmptyResultDataAccessException e) {
            return new ArrayList<Oferta>();
        }
    }


}


