package br.com.sodresoftwares.geradorcpf.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class GeradorCpfService {
	public String gerarCpfAleatorio(String uf,String pontuacao) {
		//Gerando cpf aleatorio
		Random randon = new Random();
		StringBuilder cpf = new StringBuilder();
		for(int x = 0; x < 8; x++) {
				cpf.append(randon.nextInt(10));	
		}
		//Verificando se o usuario escolheu alguma UF
		if(Character.getNumericValue(uf.charAt(0)) > 0) {
			cpf.append(uf);
		}else {
			cpf.append(randon.nextInt(10));	
		}
		String cpfCompleto = validaCpf(cpf.toString());
		cpfCompleto = gerarPontuacao(cpfCompleto, pontuacao);
		return cpfCompleto;
	}
	
	public String validaCpf(String cpf) {
		int somaTotal = 0;
		int pos = 10;
		int primeiroDigVerif;
		int segundoDigVerif;

		//Calculando primeiro digito
		for(int x = 0; x < 9; x++) {
			 somaTotal += (Character.getNumericValue(cpf.charAt(x)) * pos--);
		}
		primeiroDigVerif = 11 - (somaTotal % 11);
		if(primeiroDigVerif >= 10) {
			primeiroDigVerif = 0;
		}
		
		//Calculando segundo digito verificador
		somaTotal = 0;
		pos = 11;
		for(int x = 0; x < 9; x++) {
			 somaTotal += (Character.getNumericValue(cpf.charAt(x)) * pos--);
		}
		somaTotal += (primeiroDigVerif * 2);
		segundoDigVerif = 11 - (somaTotal % 11);
		if(segundoDigVerif >= 10) {
			segundoDigVerif = 0;
		}
		
		//Adicionando digitos ao corpo do cpf
		cpf = cpf+""+(primeiroDigVerif)+""+(segundoDigVerif);
		return cpf;
	}
	
	public Map<String, String> gerarDigitosCpf(String cpf,String pontuacao) {

		//validando cpf
		String cpfGerado = validaCpf(cpf.substring(0,9));
		//verificando se foi modificado
		boolean isModificado = !cpfGerado.equalsIgnoreCase(cpf);
		cpfGerado = gerarPontuacao(cpfGerado, pontuacao);
		//Mapeando dados do cpf
		Map<String, String> cpfDados = new HashMap<>();
		cpfDados.put("cpf", cpfGerado);
		cpfDados.put("isModificado", String.valueOf(isModificado));
		
		return cpfDados;
	}
	
	public String gerarPontuacao(String cpf, String pontuacao) {
		if(pontuacao.equalsIgnoreCase("sim")) {
			return  cpf.substring(0, 3)+"."+cpf.substring(3, 6)+ "."+cpf.substring(6, 9)+"."+cpf.substring(9, 11);
		}
		return cpf;
	}
}
