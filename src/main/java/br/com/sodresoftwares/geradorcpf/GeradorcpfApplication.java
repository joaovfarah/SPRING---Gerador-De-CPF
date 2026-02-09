package br.com.sodresoftwares.geradorcpf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"br.com.sodresoftwares.geradorcpf*"})
@EntityScan(basePackages = "br.com.sodresoftwares.geradorcpf.model")
@EnableJpaRepositories(basePackages = "br.com.sodresoftwares.geradorcpf.repository")
public class GeradorcpfApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeradorcpfApplication.class, args);
	}

}
