package domain;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class DadosComp {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "dados_id")
	private UUID id;
	
	private String Status;
	private LocalDate dataCadastro;
	private String telefones;
	private String nomeFamiliar;
	private String sexo;
	private String modDialitica;
	
	private Boolean intRecente;
	private LocalDate dataInternacao;
	private String causaInternacao;
	
	private Boolean transfRecente;
	private Boolean usaQuelante;
	private String marcaQuelante;
	private Boolean usaAlfa;
	private Boolean usaAnalogosVd;
	private Boolean usaFerro;
	private String segPTransp;
	private String localSegTransp;
	private String obs;
	
	
	@OneToMany(mappedBy = "dadosComp", cascade = CascadeType.ALL)
	private List<Doenca> doencas;
	
	@OneToMany(mappedBy = "dadosComp", cascade = CascadeType.ALL)
	private Acesso acesso;
	
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	private Clinica clinica;
	
	
	
}
