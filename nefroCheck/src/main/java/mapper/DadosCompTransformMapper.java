package mapper;

import java.util.List;

import org.mapstruct.Mapper;

import DTO.DadosCompDTO;
import domain.DadosComp;

@Mapper(componentModel = "Spring")
public abstract class DadosCompTransformMapper {

		public abstract DadosCompDTO dcToDTO(DadosComp dadosComp);
		public abstract DadosComp dcToEntity(DadosCompDTO dadosCompDTO);
		
		public abstract List<DadosCompDTO> dcLtoDTO(List<DadosComp> all);

}