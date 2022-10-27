package DTO;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

import lombok.Data;
@Data
public class DadosCompDTO implements Serializable{
		private static final long serialVersionUID = 1L;
	
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
}
