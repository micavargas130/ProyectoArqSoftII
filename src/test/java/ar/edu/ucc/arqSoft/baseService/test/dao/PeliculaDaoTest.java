package ar.edu.ucc.arqSoft.baseService.test.dao;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.ucc.arqSoft.baseService.dao.PeliculaDao;
import ar.edu.ucc.arqSoft.baseService.model.Pelicula;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml", "classpath:/spring/applicationContext.xml" })
@Transactional
public class PeliculaDaoTest {
	
	private static final Logger logger = LogManager.getLogger(PeliculaDaoTest.class);
	
	@Autowired
	private PeliculaDao peliculaDao;

	@Test
	public void testFindById() {
		logger.info("Test de busqueda de Pelicula por ID");
		Pelicula pelicula = peliculaDao.load((long) 2);
		
		Assert.assertEquals("El silencio de los inocentes", pelicula.getTitulo());
		return;
	}
	
	
	@Test
	public void testRegister() {

		logger.info("Test de Registro de Pelicula");
		Pelicula pelicula = new Pelicula();
		pelicula.setTitulo("Rambo");

		peliculaDao.insert(pelicula);
		Assert.assertEquals(3, pelicula.getId().longValue());
		return;
	}

	@Test
	public void testUpdate() {

		logger.info("Test de actualización de Pelicula");
		Pelicula state = peliculaDao.load((long) 1);
		state.setTitulo("Rambo");
		peliculaDao.update(state);

		Pelicula pelicula1 = peliculaDao.load((long) 1);
		Assert.assertEquals("Rambo", pelicula1.getTitulo());
		return;
	}
	
	
	@Test
	public void testGetAll() {

		logger.info("Test de busqueda de todas las peliculas");
		List<Pelicula> peliculas= peliculaDao.getAll();
		Assert.assertNotNull(peliculas);
		return;
	}

}
