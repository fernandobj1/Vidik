package mapper;

import java.util.List;

import org.mapstruct.Mapper;

import DTO.DoencaDTO;
import domain.Doenca;

@Mapper(componentModel = "Spring")
public abstract class DoencaTransformMapper {

		public abstract DoencaDTO doToDTO(Doenca doenca);
		public abstract Doenca doToEntity(DoencaDTO doencaDTO);
		
		public abstract List<DoencaDTO> doLtoDTO(List<Doenca> all);

}