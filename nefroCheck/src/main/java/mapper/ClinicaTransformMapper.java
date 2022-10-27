package mapper;

import java.util.List;

import org.mapstruct.Mapper;

import DTO.ClinicaDTO;
import domain.Clinica;

@Mapper(componentModel = "Spring")
public abstract class ClinicaTransformMapper {

		public abstract ClinicaDTO cliToDTO(Clinica clinica);
		public abstract Clinica cliToEntity(ClinicaDTO clinicaDTO);
		
		public abstract List<ClinicaDTO> cliLtoDTO(List<Clinica> all);

}