package com.czarate.app.usuarios.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.czarate.app.usuarios.dto.UsuarioDTO;
import com.czarate.app.usuarios.model.Usuario;
import com.czarate.app.usuarios.repository.IUsuarioRepository;

@Service
public class UsuarioService implements IUsuarioService{
	
	@Autowired
	private IUsuarioRepository usuarioRepository; 

	@Override
	public List<Usuario> findAll() {
		
		return (List<Usuario>) usuarioRepository.findAll();
	}

	@Override
	public Usuario findById(Long id) {
		return usuarioRepository.findById(id).get();
		//retorna optional envuelve entity con metodos si viene vacio o otros
	}

	@Override
	public Usuario save(UsuarioDTO usuarioDto) {
		Usuario u = new Usuario(usuarioDto);
		Date fechaActual = new Date();
		u.setCreateAt(fechaActual);
		return usuarioRepository.save(u);
	}

	@Override
	public List<Usuario> getUsuariosByCorreo(String email) {
		// TODO Auto-generated method stub
		return usuarioRepository.getUsuariosByCorreo(email);
	}

	@Override
	public Usuario updateUser(UsuarioDTO usuarioDto, Long idUsuario) {
		Usuario u = (Usuario) usuarioRepository.findById(idUsuario).get();
		u.setNombres(usuarioDto.getNombres());
		u.setApellidos(usuarioDto.getApellidos());
		u.setCorreo(usuarioDto.getCorreo());
		
		return usuarioRepository.save(u);
	}

	@Override
	public void deleteUser(Long idUsusario) {
		Usuario u = (Usuario) usuarioRepository.findById(idUsusario).get();
		usuarioRepository.delete(u);
	}

}
