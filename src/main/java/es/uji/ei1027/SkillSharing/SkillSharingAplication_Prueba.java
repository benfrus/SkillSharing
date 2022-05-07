package es.uji.ei1027.SkillSharing;

import java.util.List;
import java.util.logging.Logger;

import es.uji.ei1027.SkillSharing.dao.ColaboracionDao;
import es.uji.ei1027.SkillSharing.dao.EstudianteDao;
import es.uji.ei1027.SkillSharing.dao.EstudianteRowMapper;
import es.uji.ei1027.SkillSharing.model.Colaboracion;
import es.uji.ei1027.SkillSharing.model.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;


@SpringBootApplication
    public class SkillSharingAplication_Prueba implements CommandLineRunner {

    private static final Logger log = Logger.getLogger(es.uji.ei1027.SkillSharing.SkillSharingAplication_Prueba.class.getName());

    public static void main(String[] args) {
        // Auto-configura l'aplicació
        new SpringApplicationBuilder(es.uji.ei1027.SkillSharing.SkillSharingAplication_Prueba.class).run(args);
    }

    // Plantilla per a executar operacions sobre la connexió
    private JdbcTemplate jdbcTemplate;


    // Crea el jdbcTemplate a partir del DataSource que hem configurat
    @Autowired
    ColaboracionDao colaboracionDao;
    @Autowired
    EstudianteDao estudianteDao;
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    // Funció principal
    public void run(String... strings) throws Exception {

      log.info("Ací va el meu codi");

/*       log.info("Esta es la prueba del rowMapper");
        List<Estudiante> estudiantes = jdbcTemplate.query(
                "SELECT * FROM estudiante",
                new EstudianteRowMapper());
        for (Estudiante e : estudiantes) {
            log.info(e.toString());
        }*/
/*            log.info("Esta es la prueba del DAO");
            for (Colaboracion e : colaboracionDao.getColaboraciones()) {
                log.info(e.toString());

            }*/
        log.info("Dades de al000000");
        Estudiante n = estudianteDao.getEstudiante("al000000");
        log.info(n.toString());

       /* for (Estudiante e: estudianteDao.getEstudiantes()) {
            log.info(e.toString());
        }*/
        log.info("Dades de al000000");
        Estudiante w = estudianteDao.getEstudianteByUser("al000000");
        log.info(w.toString());




    }


    void provaEstudianteDao() {
        EstudianteDao estudianteDao = new EstudianteDao();
        log.info("Esta es la prueba del DAO");
        log.info("Provant NadadorDao");
        log.info("Tots els nadadors");

        /*for (Estudiante e : estudianteDao.getEstudiantes()) {
            log.info(e.toString());
        }*/
        log.info("Dades de al000000");
        Estudiante n = estudianteDao.getEstudiante("al000000");
        log.info(n.toString());

    }


    }










