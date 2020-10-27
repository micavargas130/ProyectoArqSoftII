package ar.edu.ucc.arqSoft.baseService.test.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.remoting.httpinvoker.AbstractHttpInvokerRequestExecutor;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ar.edu.ucc.arqSoft.baseService.dto.SocioRequestDto;
import ar.edu.ucc.arqSoft.baseService.dto.SocioResponseDto;
import ar.edu.ucc.arqSoft.baseService.service.SocioService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:test-context.xml", "classpath:/spring/applicationContext.xml" })
public class SocioServiceTest {
	

	@Autowired
	private SocioService socioService;
	
	@Test
	public void testInsert() {
		SocioRequestDto request = new SocioRequestDto();
		
		 request.setNombre("Patricia");
		 request.setApellido("Torres");
		 request.setDni("17245869");
		 request.setEmail("patricia@gmail.com");
		SocioResponseDto response = socioService.registrarSocio(request);
		
		Assert.assertEquals("Patricia", response.getNombre());
		return;
	}

}
