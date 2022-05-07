package es.uji.ei1027.SkillSharing;

import java.util.logging.Logger;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})

public class SkillSharingApplication {

	private static final Logger log = Logger.getLogger(SkillSharingApplication.class.getName());

	public static void main(String[] args) {
		// Auto-configura l'aplicació
		new SpringApplicationBuilder(SkillSharingApplication.class).run(args);

		}

/*	 Funció principal
    public void run(String... strings) throws Exception {
		log.info("Ací va el meu codi");
	}

	private JdbcTemplate jdbcTemplate;

	 Crea el jdbcTemplate a partir del DataSource que hem configurat
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




