package es.uji.ei1027.SkillSharing;

import java.util.logging.Logger;

import es.uji.ei1027.SkillSharing.dao.HabilidadRowMapper;
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
	/*private JdbcTemplate jdbcTemplate;

	// Crea el jdbcTemplate a partir del DataSource que hem configurat
	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}


	// Funció principal
	public void run(String... strings) throws Exception {
		log.info("Ací va el meu codi");

		log.info("Selecciona el bateria con id 4");
		Habilidad h1 = jdbcTemplate.queryForObject(
				"SELECT * FROM habilidad WHERE id_habilidad = '4'",
				new HabilidadRowMapper());
		log.info(h1.toString());
	}*/
}
