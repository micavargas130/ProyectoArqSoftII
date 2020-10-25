package ar.edu.ucc.arqSoft.baseService.test.dao;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.ucc.arqSoft.baseService.dao.AlquilerDao;
import ar.edu.ucc.arqSoft.baseService.model.Alquiler;
import ar.edu.ucc.arqSoft.baseService.model.Pelicula;
import ar.edu.ucc.arqSoft.baseService.model.Socio;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml", "classpath:/spring/applicationContext.xml" })
@Transactional
public class AlquilerDaoTest {
	
private static final Logger logger = LogManager.getLogger(PeliculaDaoTest.class);
	
	@Autowired
	private AlquilerDao alquilerDao;
	

	@Test
	public void testRegister() {

		logger.info("Test de Registro de Alquiler");
		Alquiler alquiler = new Alquiler();
		Pelicula pelicula = new Pelicula();
		Socio socio = new Socio();
		
		pelicula.setTitulo("Batman");
		socio.setNombre("Ana");
		alquiler.setPelicula(pelicula);
		alquiler.setSocio(socio);
	
		

		alquilerDao.insert(alquiler);
		Assert.assertEquals(1, alquiler.getId().longValue());
		return;
	}

}
