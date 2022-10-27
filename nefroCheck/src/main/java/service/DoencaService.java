package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import DTO.DoencaDTO;
import domain.Doenca;
import mapper.DoencaTransformMapper;
import repository.DoencaRepository;

public class DoencaService {

	@Autowired 
	DoencaRepository doencaRepository;
	
	@Autowired
	DoencaTransformMapper mapper;
	
	public List<DoencaDTO> listaDoencas(){
		List<DoencaDTO> doencas = new ArrayList<>();
		doencaRepository.findAll().stream().forEach(c ->{
			doencas.add(mapper.doToDTO(c));
		});
		return doencas;
	}
	
	public DoencaDTO getbyId(UUID id) throws UserNotFoundExcption {
		
		Optional<Doenca> achaDoenca = doencaRepository.findById(id);
		return mapper.doToDTO(achaDoenca.orElseThrow(() -> new UserNotFoundExcption("Não achou")));
	}

	public DoencaDTO salvaDoenca(DoencaDTO doenca) {
		
		Doenca novaDoenca = new Doenca();
		novaDoenca = doencaRepository.save(mapper.doToEntity(doenca));
		return mapper.doToDTO(novaDoenca);
	}
	
	public void excluiDoenca(UUID id) throws UserNotFoundExcption{
		Optional<Doenca> achaDoenca = doencaRepository.findById(id);
//		if(acessoRepository.findById(id).isPresent())
		if(!achaDoenca.isPresent()) {
//			List<Acesso> acessos = acessoRepository.listAllwithEsseAcesso(id);
//			acessos.foreach(u ->{
//				u.get().removeIf(t -> t.getId().equals(id));
//				usuarioRepositor.save(u);
//			});
		doencaRepository.deleteById(id);
		}
	}
}
