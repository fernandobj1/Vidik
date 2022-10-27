package controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import DTO.AcessoDTO;
import DTO.MsgRet;
import lombok.extern.log4j.Log4j2;
import service.AcessoService;
@Log4j2
@RestController
@RequestMapping(value = "/Acesso")
public class AcessosController {

	@Autowired
	AcessoService acessoService;
	
	MsgRet msg = new MsgRet();
	List<AcessoDTO> acessos = new ArrayList<>();
	AcessoDTO acessoDTO = new AcessoDTO();
	
	@GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> listaAcessos(){
		try {
			acessos = acessoService.listaAcessos();
			return new ResponseEntity<>(acessoService.listaAcessos(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
		}
	}
	@PutMapping(value = "/criar/acesso/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> criaAcesso(@PathVariable AcessoDTO acessoDTO){
		try {
			acessoDTO = acessoService.criaAcesso(acessoDTO);
			return new ResponseEntity<>(acessoDTO, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(msg, HttpStatus.OK);
		}
	}
}
