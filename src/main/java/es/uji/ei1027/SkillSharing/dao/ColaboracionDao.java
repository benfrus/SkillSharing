package es.uji.ei1027.SkillSharing.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import es.uji.ei1027.SkillSharing.model.Colaboracion;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ColaboracionDao {
    private JdbcTemplate jdbcTemplate;

    // Obté el jdbcTemplate a partir del Data Source
    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /* Afegeix la colaboracion a la base de dades */
    public void addColaboracion(Colaboracion colaboracion) {
        jdbcTemplate.update("INSERT INTO colaboracion VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)",
                colaboracion.getId_colab(), colaboracion.getFecha_inicio(), colaboracion.getFecha_fin(),
                colaboracion.getHoras_totales(), colaboracion.getEvaluacion(), colaboracion.getComenatio(),
                colaboracion.getId_oferta(), colaboracion.getId_pet(), colaboracion.getEstado());

    }

    /* Esborra el colaboracion de la base de dades */
    public void deleteColaboracion(Colaboracion colaboracion) {

        jdbcTemplate.update("DELETE FROM colaboracion WHERE id_colab  = ? ", colaboracion.getId_colab());
    }

    /* Actualitza els atributs del colaboracion
       (excepte el nom, que és la clau primària) */
    public void updateColaboracion(Colaboracion colaboracion) {
        jdbcTemplate.update("UPDATE colaboracion SET  evaluacion = ?, comenatrio = ?, estado = ? WHERE id_colab = ? ",
                colaboracion.getEvaluacion(), colaboracion.getComenatio(), colaboracion.getEstado(),
                colaboracion.getId_colab() );
    }

    /* Obté el colaboracion amb el id donat. Torna null si no existeix. */
    public Colaboracion getColaboracion(String id_colab) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM colaboracion WHERE id_colab = ?",
                    new es.uji.ei1027.SkillSharing.dao.ColaboracionRowMapper(), id_colab);
        }
        catch(EmptyResultDataAccessException e) {
            return null;
        }
    }

    /* Obté tots els colaboracion. Torna una llista buida si no n'hi ha cap. */
    public List<es.uji.ei1027.SkillSharing.model.Colaboracion> getColaboraciones() {
        try {
            return jdbcTemplate.query("SELECT * FROM colaboracion",
                    new es.uji.ei1027.SkillSharing.dao.ColaboracionRowMapper());
        }
        catch(EmptyResultDataAccessException e) {
            return new ArrayList<Colaboracion>();
        }
    }
}


