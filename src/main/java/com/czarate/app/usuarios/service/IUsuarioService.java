package com.czarate.app.usuarios.service;

import java.util.List;

import com.czarate.app.usuarios.dto.UsuarioDTO;
import com.czarate.app.usuarios.model.Usuario;

public interface IUsuarioService {
	public List<Usuario> findAll();
	public Usuario findById(Long id);
	public Usuario save(UsuarioDTO usuarioDto);
	public List<Usuario> getUsuariosByCorreo(String email);
	public Usuario updateUser(UsuarioDTO usuarirDto, Long idUsusario);
	public void deleteUser(Long idUsusario);
}
