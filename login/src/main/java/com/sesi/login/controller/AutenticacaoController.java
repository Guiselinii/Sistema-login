package com.sesi.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.sesi.login.model.Usuario;
import com.sesi.login.repository.PapelRepository;
import com.sesi.login.repository.UsuarioRepository;

@Controller
public class AutenticacaoController {
	@Autowired
	private UsuarioRepository usuarioRepositorio;
	
	@Autowired
	private PapelRepository papelRepositorio;
	
	private BCryptPasswordEncoder encoderSenha;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/registrar")
	public String mostrarFormularioRegistro(Model modelo) {
		modelo.addAttribute("usuario", new Usuario());
		return "registrar";
	}
	
	@PostMapping("/registrar")
	public String registrarUsuario(@ModelAttribute Usuario usuario, Model model) {
		if(usuarioRepositorio.findByNomeUsuario(usuario.getNomeUsuario())!= null) {
			model.addAttribute("mensagem","Nome do usuario ja existe");
			return "registrar";
	}
		//usuario.setSenha(encoderSenha.encode(usuario.getSenha()));
		usuarioRepositorio.save(usuario);
		
		return "redirect:/login";
	}
	
}
