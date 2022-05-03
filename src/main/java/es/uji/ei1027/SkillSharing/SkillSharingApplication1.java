package es.uji.ei1027.SkillSharing;

import java.util.List;
import java.util.logging.Logger;

import es.uji.ei1027.SkillSharing.dao.*;
import es.uji.ei1027.SkillSharing.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
@SpringBootApplication

public class SkillSharingApplication1 implements CommandLineRunner {

	private static final Logger log = Logger.getLogger(SkillSharingApplication1 .class.getName());

	public static void main(String[] args) {
		// Auto-configura l'aplicació
		new SpringApplicationBuilder(SkillSharingApplication1.class).run(args);
	}

	// Funció principal
	public void run(String... strings) throws Exception {
		log.info("Ací va el meu codi");
		//prova();
	}

	private JdbcTemplate jdbcTemplate;

	// Crea el jdbcTemplate a partir del DataSource que hem configurat
	@Autowired
	ColaboracionDao colaboracionDao;

	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
		log.info("Ací va el meu codi");
		// Funció principal

		log.info("Ací va el meu codi");

//		Habilidad habilidad = jdbcTemplate.queryForObject(
//				"SELECT * FROM Habilidad WHERE id_habilidad='0'",
//				new HabilidadRowMapper());
//		log.info(habilidad.toString());
//
//		Colaboracion colaboracion = jdbcTemplate.queryForObject(
//				"SELECT * FROM colaboracion WHERE id_colab='0'",
//				new ColaboracionRowMapper());
//		log.info(colaboracion.toString());
//
//		Estudiante estudiante = jdbcTemplate.queryForObject(
//				"SELECT * FROM estudiante WHERE id_estudiante='al000000'",
//				new EstudianteRowMapper());
//		log.info(estudiante.toString());
//
//		Oferta oferta = jdbcTemplate.queryForObject(
//				"SELECT * FROM oferta WHERE id_oferta='0'",
//				new OfertaRowMapper());
//		log.info(oferta.toString());
//
//		Peticion peticion = jdbcTemplate.queryForObject(
//				"SELECT * FROM peticion WHERE id_pet='0'",
//				new PeticionRowMapper());
//		log.info(peticion.toString());

	}
	void prova(){

		log.info("Provant colaboracionDAO");
		log.info("Tots els colabs");

		for (Colaboracion colab: colaboracionDao.getColaboraciones()) {
			log.info(colab.toString());
		}

		log.info("Dades de colab");
		Colaboracion colab = colaboracionDao.getColaboracion("0");
		log.info(colab.toString());

		Colaboracion eColab = new Colaboracion();
		eColab.setId_colab("2");
		eColab.setFecha_inicio("2022-02-02");
		eColab.setFecha_fin("2022-02-02");
		eColab.setHoras_totales(5);
		eColab.setEvaluacion("10");
		eColab.setComentario("Prueba comentario");
		eColab.setId_oferta("100");
		eColab.setId_pet("100");
		eColab.setEstado("Prueba");
		log.info("ID: 2");
		colaboracionDao.addColaboracion(eColab);
		log.info(colaboracionDao.getColaboracion("2").toString());

		log.info("Actualitzat:2");
		eColab.setId_oferta("2");
		eColab.setId_pet("2");
		colaboracionDao.updateColaboracion(eColab);
		log.info(colaboracionDao.getColaboracion("2").toString());

		log.info("Esborrat: 2");
		colaboracionDao.deleteColaboracion(eColab);
		if (colaboracionDao.getColaboracion("2") == null) {
			log.info("Esborrada correctament");
		}


	}

}





