package br.com.sodresoftwares.geradorcpf.security;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import br.com.sodresoftwares.geradorcpf.model.Usuario;
import br.com.sodresoftwares.geradorcpf.repository.UsuarioRepository;

@Configuration
public class WebConfigSecurity {
	private UsuarioRepository usuarioRepository;
	
	public WebConfigSecurity(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                    .anyRequest().permitAll()//perminto acesso a todas as paginas
            )
            .formLogin(login -> login 
            		.loginPage("/login")
            		.permitAll()
	                .defaultSuccessUrl("/", true)
	                .failureUrl("/login?erro=true")
            )
            .logout(logout -> logout
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/") // Redireciona para a home após logout
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
            );
        return http.build();
    }
    
    @Bean //Pega usuario do banco de dados
    public UserDetailsService userDetailsService() {
    		    return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                Usuario usuario = usuarioRepository.findUserByLogin(username);
                if (usuario == null) {
                    throw new UsernameNotFoundException("Usuário não foi encontrado");
                }
                return new User(
                    usuario.getLogin(),
                    usuario.getPassword(),
                    true, // conta ativa
                    true, // conta não expirada
                    true, // credenciais não expiradas
                    true, // conta não bloqueada
                    Collections.emptyList()
                );
            }
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Usa BCrypt para criptografar senhas
    }
}
