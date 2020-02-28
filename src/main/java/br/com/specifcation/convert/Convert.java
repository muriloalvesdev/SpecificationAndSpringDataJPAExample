package br.com.specifcation.convert;

import java.util.ArrayList;
import java.util.List;

import br.com.specifcation.domain.model.Person;
import br.com.specifcation.dto.PersonDataTransferObject;

public final class Convert {
	private Convert() {
	}

	public static List<PersonDataTransferObject> convert(List<Person> persons) {
		List<PersonDataTransferObject> personDTOs = new ArrayList<>();

		persons.stream().forEach(person -> {
			PersonDataTransferObject personDTO = new PersonDataTransferObject(person.getFirstName(),
					person.getLastName());
			personDTOs.add(personDTO);
		});

		return personDTOs;
	}
}
