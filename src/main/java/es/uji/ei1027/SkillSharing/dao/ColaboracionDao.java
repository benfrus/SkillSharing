package es.uji.ei1027.SkillSharing.dao;


import es.uji.ei1027.SkillSharing.model.DetalleColaboracion;
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
                colaboracion.getId_colab(),colaboracion.getFecha_inicio(), colaboracion.getFecha_fin(),
                colaboracion.getHoras_totales(), colaboracion.getEvaluacion(), colaboracion.getComentario(),
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
                colaboracion.getEvaluacion(), colaboracion.getComentario(), colaboracion.getEstado(),
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
    public List<Colaboracion> getColaboraciones() {
        try {
            return jdbcTemplate.query("SELECT * FROM colaboracion",
                    new es.uji.ei1027.SkillSharing.dao.ColaboracionRowMapper());
        }
        catch(EmptyResultDataAccessException e) {
            return new ArrayList<Colaboracion>();
        }
    }

    public List<Colaboracion> getColaboracionesByOferta(String id_oferta) {
        try {
            return jdbcTemplate.query("SELECT * FROM colaboracion WHERE id_oferta=?",
                    new es.uji.ei1027.SkillSharing.dao.ColaboracionRowMapper(), id_oferta);
        }
        catch(EmptyResultDataAccessException e) {
            return new ArrayList<Colaboracion>();
        }
    }

    public List<DetalleColaboracion> getDetalleColaboracionByOferta(String id_oferta) {
        try {
            return jdbcTemplate.query("select * from (select c.id_colab, e.nombre as e_oferta, o.descripcion as desc_oferta from colaboracion as c join oferta as o using(id_oferta) join estudiante as e using(id_estudiante) WHERE id_oferta=?) as oferta join (select c1.id_colab, e1.nombre as e_peticion, p.descripcion as desc_peticion from colaboracion as c1 join peticion as p using(id_pet) join estudiante as e1 using(id_estudiante) WHERE id_oferta=?) as peticion using(id_colab)",
                    new DetalleColaboracionRowMapper(), id_oferta, id_oferta);
        }
        catch(EmptyResultDataAccessException e) {
            return new ArrayList<DetalleColaboracion>();
        }
    }

    public List<DetalleColaboracion> getDetalleColaboracionByPeticion(String id_peticion) {
        try {
            return jdbcTemplate.query("SELECT * FROM colaboracion WHERE id_oferta=?",
                    new DetalleColaboracionRowMapper(), id_peticion);
        }
        catch(EmptyResultDataAccessException e) {
            return new ArrayList<DetalleColaboracion>();
        }
    }
}


