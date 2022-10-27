package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import DTO.DadosCompDTO;
import domain.DadosComp;
import mapper.DadosCompTransformMapper;
import repository.DadosCompRepository;

public class DadosCompService {

	@Autowired 
	DadosCompRepository dadosCompRepository;
	
	@Autowired
	DadosCompTransformMapper mapper;
	
	public List<DadosCompDTO> listaDadosComps(){
		List<DadosCompDTO> dadosComps = new ArrayList<>();
		dadosCompRepository.findAll().stream().forEach(c ->{
			dadosComps.add(mapper.dcToDTO(c));
		});
		return dadosComps;
	}
	
	public DadosCompDTO getbyId(UUID id) throws UserNotFoundExcption {
		
		Optional<DadosComp> achaDadosComp = dadosCompRepository.findById(id);
		return mapper.dcToDTO(achaDadosComp.orElseThrow(() -> new UserNotFoundExcption("Não achou")));
	}

	public DadosCompDTO salvaDadosComp(DadosCompDTO dadosComp) {
		
		DadosComp novoDadosComp = new DadosComp();
		novoDadosComp = dadosCompRepository.save(mapper.dcToEntity(dadosComp));
		return mapper.dcToDTO(novoDadosComp);
	}
	
	public void excluiDadosComp(UUID id) throws UserNotFoundExcption{
		Optional<DadosComp> achaDadosComp = dadosCompRepository.findById(id);
//		if(acessoRepository.findById(id).isPresent())
		if(!achaDadosComp.isPresent()) {
//			List<Acesso> acessos = acessoRepository.listAllwithEsseAcesso(id);
//			acessos.foreach(u ->{
//				u.get().removeIf(t -> t.getId().equals(id));
//				usuarioRepositor.save(u);
//			});
		dadosCompRepository.deleteById(id);
		}
	}

}
