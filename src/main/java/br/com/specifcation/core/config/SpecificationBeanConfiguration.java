package br.com.specifcation.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.specifcation.core.filter.jpa.JPAFilterBeanFactory;
import br.com.specifcation.datasource.filter.jpa.PersonSpecification;

@Configuration
public class SpecificationBeanConfiguration {

	@Bean
	public PersonSpecification personCardSpecification(JPAFilterBeanFactory filterFactory) {
		return new PersonSpecification(filterFactory);
	}

}
