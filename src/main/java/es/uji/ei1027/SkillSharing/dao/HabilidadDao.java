package es.uji.ei1027.SkillSharing.dao;

import es.uji.ei1027.SkillSharing.model.Habilidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class HabilidadDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /* Añadimos habilidad a la BBDD */

    public void addHabilidad (Habilidad habilidad){
        jdbcTemplate.update("INSERT INTO habilidad VALUES(?, ?, ?, ?, ?, ?)", habilidad.getId_hab(), habilidad.getNombre(), habilidad.getTipo(), habilidad.getDescripcion(), habilidad.getNivel(), habilidad.getEstado());
    }

    /* Eliminamos la habilidad de la BBDD */

    public void deleteHabilidad(Habilidad habilidad){
        jdbcTemplate.update ("DELETE FROM habilidad WHERE id_habilidad= ?", habilidad.getId_hab());
    }

    /* Actualizar los datos de la habilidad */

    public void updateHabilidad(Habilidad habilidad){
        jdbcTemplate.update("UPDATE habilidad SET id_habilidad= ?,  nombre= ?, tipo= ?, descripcion= ?, nivel= ?, estado= ?", habilidad.getId_hab(), habilidad.getNombre(), habilidad.getTipo(), habilidad.getDescripcion(), habilidad.getNivel(),  habilidad.getEstado());
    }

    /* Devolver los datos de un estudiante a partir de su id. Devuelve nulo si no existe en la BBDD */
    public Habilidad getHabilidad (String id_habilidad){
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM habilidad WHERE id_habilidad= ?", new HabilidadRowMapper(), id_habilidad);
        }catch(EmptyResultDataAccessException e) {
            return null;
        }
    }
    // Devuelve habilidad por nombre
    public Habilidad getHabilidadByNombre (String nombre){
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM habilidad WHERE nombre= ?", new HabilidadRowMapper(), nombre);
        }catch(EmptyResultDataAccessException e) {
            return null;
        }
    }

    /* Devolver los datos de una serie de estudiantes a partir del grado que cursan */

    public List<Habilidad> getHabillidades(){
        try{
            return jdbcTemplate.query("SELECT * FROM habilidad ", new HabilidadRowMapper());
        }
        catch(EmptyResultDataAccessException e) {
            return new ArrayList<Habilidad>();
        }
    }


}


