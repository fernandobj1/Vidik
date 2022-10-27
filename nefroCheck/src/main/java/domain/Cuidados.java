package domain;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Cuidados{
	
	@Id
	@Column(name = "cuidado_id")
	private UUID id;
	private String descCuidado;

}
