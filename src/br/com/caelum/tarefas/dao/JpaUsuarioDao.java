package br.com.caelum.tarefas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.caelum.tarefas.modelo.Usuario;

@Repository
public class JpaUsuarioDao implements UsuarioDao {

	@PersistenceContext
	EntityManager manager;
	
	@Override
	public boolean existeUsuario(Usuario usuario) {
		List<Usuario> listaDeUsuarios = manager.createQuery("select u from Usuario u "
				+ "where u.login = :login and u.senha = :senha", Usuario.class)
			.setParameter("login", usuario.getLogin())
			.setParameter("senha", usuario.getSenha())
			.getResultList();
		
		if (listaDeUsuarios.isEmpty()) // Se a lista de usuários for vazia, então não encontrou ninguém
			return false;
		else // Se não for vazia então encontrou pelo menos 1 usuário com os dados passados
			return true;
	}

}
