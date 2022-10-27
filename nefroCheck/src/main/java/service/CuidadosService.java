package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import DTO.CuidadosDTO;
import domain.Cuidados;
import mapper.CuidadosTransformMapper;
import repository.CuidadosRepository;

public class CuidadosService {

	@Autowired 
	CuidadosRepository cuidadosRepository;
	
	@Autowired
	CuidadosTransformMapper mapper;
	
	public List<CuidadosDTO> listaCuidadoss(){
		List<CuidadosDTO> cuidados = new ArrayList<>();
		cuidadosRepository.findAll().stream().forEach(c ->{
			cuidados.add(mapper.cuiToDTO(c));
		});
		return cuidados;
	}
	
	public CuidadosDTO getbyId(UUID id) throws UserNotFoundExcption {
		
		Optional<Cuidados> achaCuidados = cuidadosRepository.findById(id);
		return mapper.cuiToDTO(achaCuidados.orElseThrow(() -> new UserNotFoundExcption("Não achou")));
	}

	public CuidadosDTO salvaCuidados(CuidadosDTO cuidados) {
		
		Cuidados novosCuidados = new Cuidados();
		novosCuidados = cuidadosRepository.save(mapper.cuiToEntity(cuidados));
		return mapper.cuiToDTO(novosCuidados);
	}
	
	public void excluiCuidados(UUID id) throws UserNotFoundExcption{
		Optional<Cuidados> achaCuidados = cuidadosRepository.findById(id);
//		if(acessoRepository.findById(id).isPresent())
		if(!achaCuidados.isPresent()) {
//			List<Acesso> acessos = acessoRepository.listAllwithEsseAcesso(id);
//			acessos.foreach(u ->{
//				u.get().removeIf(t -> t.getId().equals(id));
//				usuarioRepositor.save(u);
//			});
		cuidadosRepository.deleteById(id);
		}
	}
}
