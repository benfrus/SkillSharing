package es.uji.ei1027.SkillSharing;

import java.util.List;
import java.util.logging.Logger;

import es.uji.ei1027.SkillSharing.dao.ColaboracionRowMapper;
import es.uji.ei1027.SkillSharing.dao.EstudianteRowMapper;
import es.uji.ei1027.SkillSharing.dao.HabilidadRowMapper;
import es.uji.ei1027.SkillSharing.model.Colaboracion;
import es.uji.ei1027.SkillSharing.model.Estudiante;
import es.uji.ei1027.SkillSharing.model.Habilidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootApplication
public class SkillSharingApplication {

	private static final Logger log = Logger.getLogger(SkillSharingApplication.class.getName());

	public static void main(String[] args) {
		// Auto-configura l'aplicació
		new SpringApplicationBuilder(SkillSharingApplication.class).run(args);

		}

/*	// Funció principal
    public void run(String... strings) throws Exception {
		log.info("Ací va el meu codi");
	}

	private JdbcTemplate jdbcTemplate;

	// Crea el jdbcTemplate a partir del DataSource que hem configurat
	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
		log.info("Ací va el meu codi");
		// Funció principal

			log.info("Ací va el meu codi");
		Estudiante estudiante = jdbcTemplate.queryForObject(
				"SELECT * FROM estudiante WHERE id_estudiante='0'",
				new EstudianteRowMapper());
		log.info(estudiante.toString());


		Habilidad habilidad = jdbcTemplate.queryForObject(
				"SELECT * FROM habilidad WHERE id_habilidad='0'",
				new HabilidadRowMapper());
		log.info(habilidad.toString());



		Colaboracion colaboraciones = jdbcTemplate.queryForObject(
					"SELECT * FROM colaboracion WHERE id_colab='0'",
					new ColaboracionRowMapper());
				log.info(colaboraciones.toString());



		}*/
	}




