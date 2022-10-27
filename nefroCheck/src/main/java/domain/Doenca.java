package domain;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class Doenca {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="doenca_id")
	private UUID id;
	private String nomeDoenca;
	
	@ManyToOne
	private DadosComp dadosComp;
	
	
}
