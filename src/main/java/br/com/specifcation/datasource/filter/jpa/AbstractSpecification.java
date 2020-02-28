package br.com.specifcation.datasource.filter.jpa;

import br.com.specifcation.core.filter.jpa.JPAFilter;
import br.com.specifcation.core.filter.jpa.JPAFilterBeanFactory;

public abstract class AbstractSpecification {

	private JPAFilterBeanFactory filterFactory;

	public AbstractSpecification(JPAFilterBeanFactory filterFactory) {
		this.filterFactory = filterFactory;
	}

	protected JPAFilter getNewFilterInstance() {
		return filterFactory.getInstance();
	}

}
