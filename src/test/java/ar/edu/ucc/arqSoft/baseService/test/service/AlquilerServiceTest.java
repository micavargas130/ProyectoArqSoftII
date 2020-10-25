package ar.edu.ucc.arqSoft.baseService.test.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ar.edu.ucc.arqSoft.baseService.dto.AlquilerRequestDto;
import ar.edu.ucc.arqSoft.baseService.dto.AlquilerResponseDto;
import ar.edu.ucc.arqSoft.baseService.service.AlquilerService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml", "classpath:/spring/applicationContext.xml" })
public class AlquilerServiceTest {
	
	@Autowired
	private AlquilerService alquilerService;
	
	@Test
	public void testInsert() {
		AlquilerRequestDto request = new AlquilerRequestDto();
		request.setSocioId((long) 1);
		request.setPeliculaId((long) 1);
		AlquilerResponseDto response = alquilerService.registrarAlquiler(request);
		
		Assert.assertEquals(1,response.getTitulo());
		return;
	}

}
