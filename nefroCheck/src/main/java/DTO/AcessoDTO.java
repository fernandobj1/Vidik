package DTO;

import java.io.Serializable;
import java.util.UUID;

import domain.Cuidados;
import domain.DadosComp;
import lombok.Data;

@Data
public class AcessoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

		private UUID id;
		private Integer nAcesso;
		private String acesso;
		private Integer tempoTerapia;
		private Integer tempoAcesso;		
		private DadosComp dadosComp;
		private Cuidados cuidados;
	

}
