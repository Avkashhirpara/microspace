package com.example.jpademo.tdcenter.coverageinfo;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class CoverageInfoSpecification implements Specification<CoverageInfo> {


    private SearchCriteria criteria;

    public CoverageInfoSpecification(SearchCriteria percentage) {
        criteria = percentage;
    }

    /**
     * ANDs the given {@link Specification} to the current one.
     *
     * @param other can be {@literal null}.
     * @return The conjunction of the specifications
     * @since 2.0
     */
    @Override
    public Specification<CoverageInfo> and(Specification<CoverageInfo> other) {
        return Specification.super.and(other);
    }

    /**
     * ORs the given specification to the current one.
     *
     * @param other can be {@literal null}.
     * @return The disjunction of the specifications
     * @since 2.0
     */
    @Override
    public Specification<CoverageInfo> or(Specification<CoverageInfo> other) {
        return Specification.super.or(other);
    }

    /**
     * Creates a WHERE clause for a query of the referenced entity in form of a {@link Predicate} for the given
     * {@link Root} and {@link CriteriaQuery}.
     *
     * @param root            must not be {@literal null}.
     * @param query           must not be {@literal null}.
     * @param criteriaBuilder must not be {@literal null}.
     * @return a {@link Predicate}, may be {@literal null}.
     */
    @Override
    public Predicate toPredicate(Root<CoverageInfo> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        if (criteria.getOperation().equalsIgnoreCase(">")) {
            return builder.greaterThanOrEqualTo(
                    root.<String> get(criteria.getKey()), criteria.getValue().toString());
        }
        else if (criteria.getOperation().equalsIgnoreCase("<")) {
            return builder.lessThanOrEqualTo(
                    root.<String> get(criteria.getKey()), criteria.getValue().toString());
        }
        else if (criteria.getOperation().equalsIgnoreCase(":")) {
            if (root.get(criteria.getKey()).getJavaType() == String.class) {
                return builder.like(
                        root.<String>get(criteria.getKey()), "%" + criteria.getValue() + "%");
            } else {
                return builder.equal(root.get(criteria.getKey()), criteria.getValue());
            }
        }
        return null;
    }
}
