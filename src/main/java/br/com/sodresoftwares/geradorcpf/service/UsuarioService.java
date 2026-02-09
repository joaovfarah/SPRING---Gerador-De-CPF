package br.com.sodresoftwares.geradorcpf.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.sodresoftwares.geradorcpf.model.Usuario;
import br.com.sodresoftwares.geradorcpf.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	private UsuarioRepository usuarioRepository;
	private PasswordEncoder passwordEncoder;
	
	public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
		this.usuarioRepository = usuarioRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	
	public boolean usuarioExistente(Usuario usuario) {
		if(usuarioRepository.existByLogin(usuario.getLogin())) {
			return false;
		}
		return true;
	}
	
	public void salvarUsuario(Usuario usuario) {
		usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
		usuarioRepository.save(usuario);
	}
}
