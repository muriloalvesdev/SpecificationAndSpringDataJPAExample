package br.com.specifcation.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.specifcation.domain.model.Person;
import br.com.specifcation.domain.repository.PersonRepository;

@Configuration
public class PersistPersonsConfiguration {

	@Autowired
	private PersonRepository repository;

	@Bean
	public void persist() {
		Person muriloAlves = new Person("Murilo", "Alves");
		Person muriloBatista = new Person("Murilo", "Batista");
		Person muriloSilva = new Person("Murilo", "Silva");

		repository.saveAndFlush(muriloAlves);
		repository.saveAndFlush(muriloBatista);
		repository.saveAndFlush(muriloSilva);

	}

}
