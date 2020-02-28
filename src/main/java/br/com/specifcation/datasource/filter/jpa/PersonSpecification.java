package br.com.specifcation.datasource.filter.jpa;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import br.com.specifcation.core.filter.jpa.JPAFilter;
import br.com.specifcation.core.filter.jpa.JPAFilterBeanFactory;
import br.com.specifcation.domain.model.Person;

public class PersonSpecification extends AbstractSpecification {

	public PersonSpecification(JPAFilterBeanFactory factory) {
		super(factory);
	}

	public Specification<Person> withFisrtName(String firstName) {
		return new Specification<Person>() {

			private static final long serialVersionUID = 5421913755426787046L;

			@Override
			public Predicate toPredicate(Root<Person> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				JPAFilter filter = getNewFilterInstance();

				return filter.addPredicate((b, e) -> b.like(e.get("firstName"), firstName))
						.getPredicate(criteriaBuilder, root);
			}

		};

	}

}
