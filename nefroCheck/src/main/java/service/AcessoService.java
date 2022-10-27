package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DTO.AcessoDTO;
import domain.Acesso;
import mapper.AcessoTransformMapper;
import repository.AcessoRepository;

@Service
public class AcessoService {

	@Autowired
	public AcessoRepository acessoRepository;
	
	@Autowired
	AcessoTransformMapper mapper;
	
	public List<AcessoDTO> listaAcessos(){
		List<AcessoDTO> acessos = new ArrayList<>();
		acessoRepository.findAll().stream().forEach(a -> {
			acessos.add(mapper.acsToDTO(a));
		});
			
		return acessos;
	}	
	public AcessoDTO getbyId(UUID id) throws UserNotFoundExcption {
		
		Optional<Acesso> achaAcesso = acessoRepository.findById(id);
		return mapper.acsToDTO(achaAcesso.orElseThrow(() -> new UserNotFoundExcption("Não achou")));
	}

	public AcessoDTO criaAcesso(AcessoDTO acesso) {
		
		Acesso novoAcesso = new Acesso();
		novoAcesso = acessoRepository.save(mapper.acsToEntity(acesso));
		return mapper.acsToDTO(novoAcesso);
	}
	
	public void excluiacesso(UUID id) throws UserNotFoundExcption{
		Optional<Acesso> achaacesso = acessoRepository.findById(id);
//		if(acessoRepository.findById(id).isPresent())
		if(!achaacesso.isPresent()) {
//			List<Acesso> acessos = acessoRepository.listAllwithEsseAcesso(id);
//			acessos.foreach(u ->{
//				u.get().removeIf(t -> t.getId().equals(id));
//				usuarioRepositor.save(u);
//			});
		acessoRepository.deleteById(id);
		}
	
//	public AcessoVascular findById(UUID id) {
//		
//		return AcessoVascular;
	}
}
