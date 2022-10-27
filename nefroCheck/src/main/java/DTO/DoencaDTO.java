package DTO;

import java.io.Serializable;
import java.util.UUID;

import lombok.Data;
@Data
public class DoencaDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private UUID id;
	private String nomeDoenca;

}
