package br.com.specifcation.core.filter.jpa;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public interface JPAFilter {

	JPAFilter addPredicate(BiFunction<CriteriaBuilder, Root<?>, Predicate> predicate);

	JPAFilter addJoins(Function<Root<?>, List<Join<?, ?>>> joins);

	JPAFilter addGroupBy(Function<Root<?>, List<Expression<?>>> groupBy);

	JPAFilter addLikePredicate(Path<String> path, String value);

	Function<Root<?>, List<Expression<?>>> getGroupBy();

	List<BiFunction<CriteriaBuilder, Root<?>, Predicate>> getPredicates();

	Function<Root<?>, List<Join<?, ?>>> getJoins();

	Predicate getPredicate(CriteriaBuilder builder, Root<?> root);

}