package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import DTO.PacienteDTO;
import domain.Paciente;
import mapper.PacienteTransformMapper;
import repository.PacienteRepository;

public class PacienteService {

	@Autowired 
	PacienteRepository pacienteRepository;
	
	@Autowired
	PacienteTransformMapper mapper;
	
	public List<PacienteDTO> listaPacientes(){
		List<PacienteDTO> pacientes = new ArrayList<>();
		pacienteRepository.findAll().stream().forEach(c ->{
			pacientes.add(mapper.paToDTO(c));
		});
		return pacientes;
	}
	
	public PacienteDTO getbyId(UUID id) throws UserNotFoundExcption {
		
		Optional<Paciente> achaPaciente = pacienteRepository.findById(id);
		return mapper.paToDTO(achaPaciente.orElseThrow(() -> new UserNotFoundExcption("Não achou")));
	}

	public PacienteDTO salvaPaciente(PacienteDTO paciente) {
		
		Paciente novoPaciente = new Paciente();
		novoPaciente = pacienteRepository.save(mapper.paToEntity(paciente));
		return mapper.paToDTO(novoPaciente);
	}
	
	public void excluiPaciente(UUID id) throws UserNotFoundExcption{
		Optional<Paciente> achaPaciente = pacienteRepository.findById(id);
//		if(acessoRepository.findById(id).isPresent())
		if(!achaPaciente.isPresent()) {
//			List<Acesso> acessos = acessoRepository.listAllwithEsseAcesso(id);
//			acessos.foreach(u ->{
//				u.get().removeIf(t -> t.getId().equals(id));
//				usuarioRepositor.save(u);
//			});
		pacienteRepository.deleteById(id);
		}
	}
}
