package ar.edu.ucc.arqSoft.baseService.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.ucc.arqSoft.baseService.dao.PeliculaDao;
import ar.edu.ucc.arqSoft.baseService.dto.PeliculaResponseDto;
import ar.edu.ucc.arqSoft.baseService.model.Pelicula;
import ar.edu.ucc.arqSoft.common.dto.ModelDtoConverter;

@Service
@Transactional
public class PeliculaService {
	
	
	@Autowired
	private PeliculaDao peliculaDao;
	
	
	public PeliculaResponseDto getPeliculaById (Long id) {
		
		Pelicula pelicula = peliculaDao.load(id);
		
		PeliculaResponseDto dto = new PeliculaResponseDto();
		dto.setTitulo(pelicula.getTitulo());
		
		return dto;
		
	}
	
	public List<PeliculaResponseDto> getAllPeliculas() {
		List<Pelicula> peliculas = peliculaDao.getAll();
		
		List<PeliculaResponseDto> response = new ArrayList<PeliculaResponseDto>();
		 
		for (Pelicula pelicula : peliculas) {
			response.add((PeliculaResponseDto) new ModelDtoConverter().convertToDto(pelicula, new PeliculaResponseDto()));
		}
		
		return response;
	}
	




}
