package ar.edu.ucc.arqSoft.baseService.test.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.ucc.arqSoft.baseService.dao.SocioDao;
import ar.edu.ucc.arqSoft.baseService.model.Socio;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml", "classpath:/spring/applicationContext.xml" })
@Transactional
public class SocioDaoTest {
	@Autowired
	private SocioDao socioDao;

	@Test
	public void testFindById() {
		Socio socio = socioDao.load((long) 1);

		Assert.assertEquals("SANCHEZ", socio.getApellido().toUpperCase());
		return;
	}

}
