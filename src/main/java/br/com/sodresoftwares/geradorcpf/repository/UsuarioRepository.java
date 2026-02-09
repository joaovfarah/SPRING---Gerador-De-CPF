package br.com.sodresoftwares.geradorcpf.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.sodresoftwares.geradorcpf.model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
	
	@Query("Select COUNT(u) > 0 from Usuario u where u.login = ?1")
	boolean existByLogin(String login);
	
	@Query("Select u from Usuario u where u.login = ?1")
	Usuario findUserByLogin(String login);
}
