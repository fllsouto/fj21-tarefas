package br.com.caelum.tarefas.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.tarefas.dao.UsuarioDao;
import br.com.caelum.tarefas.modelo.Usuario;

@Controller
public class LoginController {

	@Autowired
	@Qualifier("jpaUsuarioDao")
	private UsuarioDao dao;
		
	@RequestMapping("loginForm")
	public String loginForm() {
		return "formulario-login";
	}
	
	@RequestMapping("efetuaLogin")
	public String efetuaLogin(Usuario usuario, HttpSession session) {
		if(dao.existeUsuario(usuario)) {
			session.setAttribute("usuarioLogado", usuario);
			return "menu";
		} else {
			return "redirect:loginForm";
		}
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:loginform";
	}
}
