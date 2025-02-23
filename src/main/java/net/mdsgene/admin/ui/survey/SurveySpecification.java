package net.mdsgene.admin.ui.survey;

import net.mdsgene.admin.ui.survey.common.Routes;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public class SurveySpecification implements Specification<SurveySpecification> {

    private List<SearchCriteria> list = new ArrayList<>();

    public void add(SearchCriteria criteria) {
        list.add(criteria);
    }

    private Specification<SurveySpecification> onlyParent() {
        return ((root, query, criteriaBuilder) -> {
            Join<Object, Object> parent = root.join("parent");
            Predicate equal = criteriaBuilder.equal(root.get("parentId"), 0L);
            Predicate nullable = criteriaBuilder.isNull(root.get("parentId"));
            return criteriaBuilder.and(criteriaBuilder.or(equal, nullable));
        });
    }

    @Override
    public Predicate toPredicate(Root<SurveySpecification> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        List<Predicate> predicates = new ArrayList<>();

        for (SearchCriteria criteria : list) {
            if (criteria.getKey().equals("parent")) {
                Predicate nullable = builder.isNull(root.get("parent"));
                predicates.add(nullable);
                continue;
            }
            switch (criteria.getOperation()) {
                case LIKE:
                    //check if key contains comma
                    if (criteria.getKey().contains(",")) {
                        //splitting key
                        String[] keys = criteria.getKey().split(",");
                        predicates.add(builder.or(
                                builder.like(builder.lower(root.get(keys[0])), "%" + criteria.getValue().toString().toLowerCase() + "%"),
                                builder.like(builder.lower(root.get(keys[1])), "%" + criteria.getValue().toString().toLowerCase() + "%")
                        ));
                    } else {
                        predicates.add(builder.like(builder.lower(root.get(criteria.getKey())), "%" + criteria.getValue().toString().toLowerCase() + "%"));
                    }
                    break;
                case EQUAL:
                    if (criteria.getValue() == null) {
                        predicates.add(builder.isNull(root.get(criteria.getKey())));
                    } else if (criteria.getValue() instanceof Enum) {
                        predicates.add(builder.equal(root.get(criteria.getKey()), criteria.getValue()));
                    } else if (isNumeric(criteria.getValue().toString())) {
                        Predicate equal = builder.equal(root.get(criteria.getKey()), Long.parseLong(criteria.getValue().toString()));
                        Predicate nullable = builder.isNull(root.get(criteria.getKey()));
                        predicates.add(builder.or(equal, nullable));
                    } else {
                    }
                    break;
                case NOT_EQUAL:
                    if (criteria.getValue() == null) {
                        predicates.add(builder.isNotNull(root.get(criteria.getKey())));
                    } else if (criteria.getValue() instanceof Enum) {
                        predicates.add(builder.notEqual(root.get(criteria.getKey()), criteria.getValue()));
                    } else if (isNumeric(criteria.getValue().toString())) {
                        Predicate equal = builder.notEqual(root.get(criteria.getKey()), Long.parseLong(criteria.getValue().toString()));
                        Predicate nullable = builder.isNotNull(root.get(criteria.getKey()));
                        predicates.add(builder.and(equal, nullable));
                    } else {
                    }
                    break;
                case GREATER_THAN:
                    if (isNumeric(criteria.getValue().toString())) {
                        predicates.add(builder.greaterThan(root.get(criteria.getKey()), Long.parseLong(criteria.getValue().toString())));
                    }
                    break;
                case LESS_THAN:
                    if (isNumeric(criteria.getValue().toString())) {
                        predicates.add(builder.lessThan(root.get(criteria.getKey()), Long.parseLong(criteria.getValue().toString())));
                    }
                    break;
                default:
                    throw new UnsupportedOperationException("Operation not supported: " + criteria.getOperation());
            }
        }

        return builder.and(predicates.toArray(new Predicate[0]));
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}