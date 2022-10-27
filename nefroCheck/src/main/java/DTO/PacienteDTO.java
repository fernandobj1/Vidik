package DTO;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

import lombok.Data;
@Data
public class PacienteDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private UUID id;
	private String nomePaciente;
	private LocalDate dataNasc;
	private String cpf;
	

}
