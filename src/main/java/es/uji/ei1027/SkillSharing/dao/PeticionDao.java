package es.uji.ei1027.SkillSharing.dao;

import es.uji.ei1027.SkillSharing.model.Habilidad;
import es.uji.ei1027.SkillSharing.model.Oferta;
import es.uji.ei1027.SkillSharing.model.Peticion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PeticionDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /* Añadimos oferta a la BBDD */

    public void addPeticion (Peticion peticion){
        jdbcTemplate.update("INSERT INTO peticion VALUES(?, ?, ?, ?, ?, ?, ?)", peticion.getId_Pet(), peticion.getFecha_Inicio(), peticion.getFecha_Fin(), peticion.getDescripcion(), peticion.getId_Habilidad(), peticion.getId_Estudiante(), peticion.getEstado());
    }

    /* Eliminamos la oferta de la BBDD */

    public void deletePeticion(Peticion peticion){
        jdbcTemplate.update ("DELETE FROM peticion WHERE id_pet= ?", peticion.getId_Pet());
    }

    /* Actualizar los datos de la habilidad */

    public void updatePeticion(Peticion peticion){
        jdbcTemplate.update("UPDATE peticion SET id_pet= ?,  fecha_inicio= ?, fecha_fin= ?, descripcion= ?, id_habilidad= ?, id_estudiante= ?, estado=? where id_pet=?", peticion.getId_Pet(), peticion.getFecha_Inicio(), peticion.getFecha_Fin(), peticion.getDescripcion(), peticion.getId_Habilidad(), peticion.getId_Estudiante(),peticion.getEstado(), peticion.getId_Pet());
    }

    /* Devolver los datos de un estudiante a partir de su id. Devuelve nulo si no existe en la BBDD */
    public Peticion getPeticion (String id_peticion){
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM peticion WHERE id_pet= ?", new PeticionRowMapper(), id_peticion);
        }catch(EmptyResultDataAccessException e) {
            return null;
        }
    }

    /* Devolver los datos de una serie de estudiantes a partir del grado que cursan */

    public List<Peticion> getPeticiones(){
        try{
            return jdbcTemplate.query("SELECT * FROM peticion ", new PeticionRowMapper());
        }
        catch(EmptyResultDataAccessException e) {
            return new ArrayList<Peticion>();
        }
    }
    public List<Peticion> getPeticionesByUser(String id_estudiante){
        try{
            return jdbcTemplate.query("SELECT * FROM peticion WHERE id_estudiante=?", new PeticionRowMapper(), id_estudiante);
        }
        catch(EmptyResultDataAccessException e) {
            return new ArrayList<Peticion>();
        }
    }

    public List<Peticion> getPeticionesParaColaborar(String id_hab, LocalDate fecha_Fin, String id_estudiante, String id_oferta){
        try{
            return jdbcTemplate.query("SELECT * FROM peticion WHERE id_habilidad=? and fecha_fin>=? and id_estudiante!=? and estado!='colaborando' and id_pet NOT IN(SELECT id_pet FROM colaboracion WHERE id_oferta = ?)", new PeticionRowMapper(), id_hab, fecha_Fin, id_estudiante, id_oferta);
        }
        catch(EmptyResultDataAccessException e) {
            return new ArrayList<Peticion>();
        }
    }


}


