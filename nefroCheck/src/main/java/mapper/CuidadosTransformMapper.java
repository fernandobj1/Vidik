package mapper;

import java.util.List;

import org.mapstruct.Mapper;

import DTO.CuidadosDTO;
import domain.Cuidados;

@Mapper(componentModel = "Spring")
public abstract class CuidadosTransformMapper {

		public abstract CuidadosDTO cuiToDTO(Cuidados cuidados);
		public abstract Cuidados cuiToEntity(CuidadosDTO cuidadosDTO);
		
		public abstract List<CuidadosDTO> cuiLtoDTO(List<Cuidados> all);

}