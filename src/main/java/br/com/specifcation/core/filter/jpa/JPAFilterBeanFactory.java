package br.com.specifcation.core.filter.jpa;

public class JPAFilterBeanFactory {

	public JPAFilter getInstance() {
		return new JPADefaultFilter();
	}

}
