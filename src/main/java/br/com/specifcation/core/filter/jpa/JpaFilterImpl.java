package br.com.specifcation.core.filter.jpa;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public abstract class JpaFilterImpl implements JPAFilter {

	private List<BiFunction<CriteriaBuilder, Root<?>, Predicate>> predicates;
	private Function<Root<?>, List<Join<?, ?>>> joins;
	private Function<Root<?>, List<Expression<?>>> groupBy;

	public JpaFilterImpl() {
		this.predicates = new ArrayList<BiFunction<CriteriaBuilder, Root<?>, Predicate>>();
	}

	@Override
	public JPAFilter addPredicate(final BiFunction<CriteriaBuilder, Root<?>, Predicate> predicate) {
		predicates.add(predicate);
		return this;
	}

	@Override
	public JPAFilter addJoins(final Function<Root<?>, List<Join<?, ?>>> joins) {
		this.joins = joins;
		return this;
	}

	@Override
	public JPAFilter addGroupBy(Function<Root<?>, List<Expression<?>>> groupBy) {
		this.groupBy = groupBy;
		return this;
	}

	@Override
	public Function<Root<?>, List<Expression<?>>> getGroupBy() {
		return groupBy;
	}

	@Override
	public List<BiFunction<CriteriaBuilder, Root<?>, Predicate>> getPredicates() {
		return predicates;
	}

	@Override
	public Function<Root<?>, List<Join<?, ?>>> getJoins() {
		return joins;
	}

	public JPAFilter addLikPredicate() {
		return this;
	}

	@Override
	public Predicate getPredicate(CriteriaBuilder builder, Root<?> root) {

		return builder.and(getPredicates().stream().map(f -> f.apply(builder, root)).collect(Collectors.toList())
				.toArray(new Predicate[] {}));
	}

	@Override
	public JPAFilter addLikePredicate(Path<String> path, String value) {
		return addPredicate((b, e) -> b.like(path, "%" + value + "%"));
	}

}
