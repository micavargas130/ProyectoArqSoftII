package ar.edu.ucc.arqSoft.baseService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

import ar.edu.ucc.arqSoft.baseService.dto.EstadoRequestDto;
import ar.edu.ucc.arqSoft.baseService.dto.EstadoResponseDto;
import ar.edu.ucc.arqSoft.baseService.dto.ProyectoResponseDto;
import ar.edu.ucc.arqSoft.baseService.service.EstadoService;
import ar.edu.ucc.arqSoft.common.exception.BadRequestException;
import ar.edu.ucc.arqSoft.common.exception.EntityNotFoundException;

@Controller
@RequestMapping("/estado")
public class EstadoController {

	@Autowired
    private EstadoService estadoService;
	
	@RequestMapping(method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public @ResponseBody EstadoResponseDto insertEstado(@RequestBody EstadoRequestDto request)
    {
        return estadoService.insertEstado(request);
    }
	
	 @RequestMapping(method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	    public @ResponseBody List<EstadoResponseDto> getAllEstados()
	    {
	        return estadoService.getAllEstado();
	    }
	 
	 @RequestMapping(value="/{id}", method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	    public @ResponseBody EstadoResponseDto getEstadoById(@PathVariable("id") Long id)
	    {
	        
	    try {
			EstadoResponseDto dto = estadoService.getEstadoById(id);		
			return dto;
			
		} catch (EntityNotFoundException e) {
			
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Estado no encontrado", e);
			
		} catch (BadRequestException e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad Request - ID = 0 o negativo", e);
	}
	    }

	
}