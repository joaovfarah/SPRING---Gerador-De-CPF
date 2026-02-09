package br.com.sodresoftwares.geradorcpf.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.sodresoftwares.geradorcpf.service.GeradorCpfService;

@Controller
public class GeradorCpfController {
	
	public GeradorCpfService geradorCpfService;
	
	public GeradorCpfController(GeradorCpfService geradorCpfService) {
		this.geradorCpfService = geradorCpfService;
	}
	
	@GetMapping("/")
	public String acessarPagina() {
		return "/gerador-cpf/gerador-cpf";
	}
	
	@PostMapping("/gerar-cpf-aleatorio")
	public String gerarCpfAleatorio(RedirectAttributes redirectAttributes,
									@RequestParam("acao")String acao, @RequestParam("uf")String uf,
									@RequestParam("pontuacao") String pontuacao,
									@RequestParam("cpf")String cpfDigitado) {
		String cpf;
		if(acao.equalsIgnoreCase("gerar")) {
			/*Gerando CPF Aleatorio*/
			 cpf = geradorCpfService.gerarCpfAleatorio(uf,pontuacao);
			redirectAttributes.addFlashAttribute("cpf", cpf);
		
		}else if (acao.equalsIgnoreCase("validar")) {
			/*Validando digitos do cpf*/
			Map<String, String> cpfDados = geradorCpfService.gerarDigitosCpf(cpfDigitado, pontuacao);
			redirectAttributes.addFlashAttribute("cpf", cpfDados.get("cpf"));
			
			//testando se o cpf digitado é valido
			if(cpfDados.get("isModificado").equalsIgnoreCase("true")) {
				redirectAttributes.addFlashAttribute("msgvalido", "O CPF informado estava com os dígitos "
						+ "incorretos, então ajustamos isso para você!");
			}else {
				redirectAttributes.addFlashAttribute("msgvalido","O CPF informado está correto!");
			}
		}
		return "redirect:/";
	}
}
