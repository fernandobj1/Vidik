package domain;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;

@Data
@Entity
public class Paciente {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "paciente_id")
	private UUID id;
	private String nomePaciente;
	private LocalDate dataNasc;
	private String cpf;

	@OneToOne(cascade = CascadeType.ALL)
	private DadosComp dadosComp;
}
