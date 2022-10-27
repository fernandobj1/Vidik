package domain;

import java.util.UUID;

import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
public class Clinica {

	private UUID id;
	private String nomeClinica;
}
