package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DTO.ClinicaDTO;
import domain.Clinica;
import mapper.ClinicaTransformMapper;
import repository.ClinicaRepository;

@Service
public class ClinicaService {

	@Autowired 
	ClinicaRepository clinicaRepository;
	
	@Autowired
	ClinicaTransformMapper mapper;
	
	public List<ClinicaDTO> listaClinicas(){
		List<ClinicaDTO> clinicas = new ArrayList<>();
		clinicaRepository.findAll().stream().forEach(c ->{
			clinicas.add(mapper.cliToDTO(c));
		});
		return clinicas;
	}
	
	public ClinicaDTO getbyId(UUID id) throws UserNotFoundExcption {
		
		Optional<Clinica> achaClinica = clinicaRepository.findById(id);
		return mapper.cliToDTO(achaClinica.orElseThrow(() -> new UserNotFoundExcption("Não achou")));
	}

	public ClinicaDTO salvaClinica(ClinicaDTO clinica) {
		
		Clinica novaClinica = new Clinica();
		novaClinica = clinicaRepository.save(mapper.cliToEntity(clinica));
		return mapper.cliToDTO(novaClinica);
	}
	
	public void excluiClinica(UUID id) throws UserNotFoundExcption{
		Optional<Clinica> achaClinica = clinicaRepository.findById(id);
//		if(acessoRepository.findById(id).isPresent())
		if(!achaClinica.isPresent()) {
//			List<Acesso> acessos = acessoRepository.listAllwithEsseAcesso(id);
//			acessos.foreach(u ->{
//				u.get().removeIf(t -> t.getId().equals(id));
//				usuarioRepositor.save(u);
//			});
		clinicaRepository.deleteById(id);
		}
	}
	
}
