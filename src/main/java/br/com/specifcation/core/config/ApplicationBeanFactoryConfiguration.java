package br.com.specifcation.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.specifcation.core.filter.jpa.JPAFilterBeanFactory;

@Configuration
public class ApplicationBeanFactoryConfiguration {

	@Bean
	public JPAFilterBeanFactory jpaFilterBeanFactory() {
		return new JPAFilterBeanFactory();
	}
}
