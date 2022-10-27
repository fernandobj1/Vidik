package mapper;

import java.util.List;

import org.mapstruct.Mapper;

import DTO.PacienteDTO;
import domain.Paciente;

@Mapper(componentModel = "Spring")
public abstract class PacienteTransformMapper {

		public abstract PacienteDTO paToDTO(Paciente paciente);
		public abstract Paciente paToEntity(PacienteDTO pacienteDTO);
		
		public abstract List<PacienteDTO> paLtoDTO(List<Paciente> all);

}