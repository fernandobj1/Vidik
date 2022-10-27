package controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import DTO.ClinicaDTO;
import DTO.MsgRet;
import lombok.extern.log4j.Log4j2;
import service.ClinicaService;

@Log4j2
@RestController
@RequestMapping(value = "/V1")
public class ClinicaController {
	
	@Autowired
	ClinicaService clinicaService;
	
	MsgRet msg = new MsgRet();
	List<ClinicaDTO> clinicas = new ArrayList<>();
	ClinicaDTO clinica = new ClinicaDTO();
	
	@GetMapping(value = "/listar/clinica", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> listaClinicas(){
		try {
			clinicas = clinicaService.listaClinicas();
			return new ResponseEntity<>(clinicas, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping(value = "/buscar/clinica/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> buscaClinica(@PathVariable ("id") UUID id){
		try {
			clinica = clinicaService.getbyId(id);
			return new ResponseEntity<>(clinica, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping(value = "/criar/clinica", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> criaClinica(@PathVariable ClinicaDTO clinicaDTO){
		try {
			clinica = clinicaService.salvaClinica(clinicaDTO);
			return new ResponseEntity<>(clinica, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
		}
	}
	@PutMapping(value = "/criar/clinica", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> alteraClinica(@PathVariable ClinicaDTO clinicaDTO){
		try {
			clinica = clinicaService.salvaClinica(clinicaDTO);
			return new ResponseEntity<>(clinica, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(msg, HttpStatus.NOT_FOUND);
		}
	}
	@DeleteMapping(value = "/exclui/clinica/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> excluiClinica(@PathVariable UUID id){
		try {
			clinicaService.excluiClinica(id);
			return new ResponseEntity<>(clinica, HttpStatus.OK);			
		} catch (Exception e) {
			return new ResponseEntity<>(clinica, HttpStatus.NOT_FOUND);
		}
	}
}
