package domain;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;
@Entity
@Data
public class Acesso {

	@Column(name="acesso_id")
	private UUID id;
	private Integer nAcesso;
	private String acesso;
	private Integer tempoTerapia;
	private Integer tempoAcesso;
	
	@ManyToOne
	private DadosComp dadosComp;
	
	@OneToOne
	private Cuidados cuidados;
}
