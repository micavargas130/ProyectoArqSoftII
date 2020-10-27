package ar.edu.ucc.arqSoft.baseService.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.ucc.arqSoft.baseService.dto.SocioRequestDto;
import ar.edu.ucc.arqSoft.baseService.dto.SocioResponseDto;
import ar.edu.ucc.arqSoft.baseService.model.Socio;
import ar.edu.ucc.arqSoft.baseService.dao.SocioDao;

@Service
@Transactional
public class SocioService {
	
	
	@Autowired
	private SocioDao socioDao;
	
public SocioResponseDto registrarSocio (SocioRequestDto dto) {
		
		Socio socio = new Socio();
		
		
		socioDao.insert(socio);
		
		SocioResponseDto response = new SocioResponseDto();
		
		response.setNombre(socio.getNombre());
		response.setApellido(socio.getApellido());
		response.setDNI(socio.getDni());
		response.setEmail(socio.getEmail());
		
		return response;
		
	}

}
