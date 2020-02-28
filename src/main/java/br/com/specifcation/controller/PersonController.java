package br.com.specifcation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.specifcation.dto.PersonDataTransferObject;
import br.com.specifcation.service.PersonService;

@RestController
@RequestMapping("api/person")
public class PersonController {

	@Autowired
	private PersonService service;

	@GetMapping("find")
	public ResponseEntity<List<PersonDataTransferObject>> findByFirstName(
			@RequestParam(name = "firstName", required = true) String firstName) {
		return ResponseEntity.ok(service.findByFirstName(firstName));
	}

}
