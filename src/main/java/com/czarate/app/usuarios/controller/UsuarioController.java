package com.czarate.app.usuarios.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.czarate.app.usuarios.dto.UsuarioDTO;
import com.czarate.app.usuarios.model.Usuario;
import com.czarate.app.usuarios.service.IUsuarioService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/v1/usuarios")
@Slf4j
public class UsuarioController {
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@GetMapping("")
	public ResponseEntity<List<Usuario>> getUsuarios(){
		try {
			List<Usuario> usuarios = usuarioService.findAll();
			return ResponseEntity.status(HttpStatus.OK).body(usuarios);
		}
		catch(Exception ex) {
			log.error(ex.getMessage());
			return ResponseEntity.internalServerError().build();
		}
	}
	
	@PostMapping("")
	@Transactional
	public ResponseEntity<?> guardarUsuario(@Valid @RequestBody UsuarioDTO usuarioDTO,BindingResult result){
		try {
			 if (result.hasErrors()) {
		        log.info("Error campos no validos");
		        return ResponseEntity.unprocessableEntity().body("Error campos no validos");
			 }
			Usuario usuario = usuarioService.save(usuarioDTO);
			/*if(result.hasErrors()) {
				log.info("Error campos no validos");
				return ResponseEntity.unprocessableEntity().build();
			}*/
			log.info("Usuario creado");
			return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
		}
		catch(Exception ex) {
			log.error(ex.getMessage());
			return ResponseEntity.internalServerError().build();
		}
	}

}
