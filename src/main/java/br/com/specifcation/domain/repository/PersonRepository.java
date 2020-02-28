package br.com.specifcation.domain.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import br.com.specifcation.domain.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, UUID>, JpaSpecificationExecutor<Person> {
}
