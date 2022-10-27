package mapper;

import java.util.List;

import org.mapstruct.Mapper;

import DTO.AcessoDTO;
import domain.Acesso;

@Mapper(componentModel = "Spring")
public abstract class AcessoTransformMapper {

	public abstract AcessoDTO acsToDTO(Acesso acesso);
	public abstract Acesso acsToEntity(AcessoDTO acessoDTO);
	public abstract List<AcessoDTO> acsltoDTO(List<Acesso> all);
}
