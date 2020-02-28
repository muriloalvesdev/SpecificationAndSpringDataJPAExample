package br.com.specifcation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.specifcation.convert.Convert;
import br.com.specifcation.datasource.filter.jpa.PersonSpecification;
import br.com.specifcation.domain.model.Person;
import br.com.specifcation.domain.repository.PersonRepository;
import br.com.specifcation.dto.PersonDataTransferObject;

@Service
public class PersonService {

	@Autowired
	private PersonSpecification specification;

	@Autowired
	private PersonRepository repository;

	public List<PersonDataTransferObject> findByFirstName(String firstName) {
		List<Person> persons = repository.findAll(specification.withFisrtName(firstName));
		return Convert.convert(persons);
	}
}
