package br.com.caelum.tarefas.dao;

import br.com.caelum.tarefas.modelo.Usuario;

public interface UsuarioDao {
	public boolean existeUsuario(Usuario usuario);
}
