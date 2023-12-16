package com.czarate.app.usuarios.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.czarate.app.usuarios.model.Usuario;

public interface IUsuarioRepository extends CrudRepository<Usuario, Long> {
	@Query("SELECT u FROM Usuario u WHERE u.correo = ?1")
	public List<Usuario> getUsuariosByCorreo(String correo);

}
