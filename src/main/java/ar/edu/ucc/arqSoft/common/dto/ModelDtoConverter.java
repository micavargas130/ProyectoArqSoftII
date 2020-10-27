package ar.edu.ucc.arqSoft.common.dto;

import org.modelmapper.ModelMapper;

import ar.edu.ucc.arqSoft.baseService.dto.PeliculaResponseDto;

public class ModelDtoConverter {

	public DtoEntity convertToDto(Object obj, PeliculaResponseDto peliculaResponseDto) {
		return (DtoEntity) new ModelMapper().map(obj, peliculaResponseDto.getClass());
	}

	public Object convertToEntity(Object obj, DtoEntity mapper) {
		return new ModelMapper().map(mapper, obj.getClass());
	}
}
