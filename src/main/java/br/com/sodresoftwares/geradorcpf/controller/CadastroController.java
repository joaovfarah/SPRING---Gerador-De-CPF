package br.com.sodresoftwares.geradorcpf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.sodresoftwares.geradorcpf.model.Usuario;
import br.com.sodresoftwares.geradorcpf.service.UsuarioService;

@Controller
public class CadastroController {
	
	private UsuarioService usuarioService;
	
	public CadastroController(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	@GetMapping("/cadastro")
	public String paginaCadastro() {
		return "/cadastro/cadastro";
	}
	
	@PostMapping("/salvarUsuario")
	public String salvarUsuario(Usuario usuario, RedirectAttributes redirectAttributes) {
		if(!usuarioService.usuarioExistente(usuario)) {
			redirectAttributes.addFlashAttribute("mensagemErro", "Este nome de usuário já está sendo usuado");
			return"redirect:/cadastro";
		}
		usuarioService.salvarUsuario(usuario);
		return "redirect:/login";
	}
}
