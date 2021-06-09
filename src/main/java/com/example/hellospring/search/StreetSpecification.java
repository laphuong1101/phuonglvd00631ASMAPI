package com.example.hellospring.search;

import com.example.hellospring.entity.Street;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StreetSpecification implements Specification<Street> {
    private SearchCriteria searchCriteria;

    @Override
    public Predicate toPredicate(Root<Street> root, // bang truy van
                                 CriteriaQuery<?> criteriaQuery,
                                 CriteriaBuilder criteriaBuilder) { // dung de tao cau truy van

        if (this.searchCriteria.getOperation().equals("like")) {
            // method like 2 tham so: 1 la truong se dem ra loc/ so sanh, 2 la dieu kien loc/so sanh
            return criteriaBuilder.like(root.get(searchCriteria.getKey()), "%"+ searchCriteria.getValue().toString() + "%");
        } else if (this.searchCriteria.getOperation().equals("==")) {
            return criteriaBuilder.equal(root.get(searchCriteria.getKey()), searchCriteria.getValue());
        } else if (this.searchCriteria.getOperation().equals(">=")) {
            return criteriaBuilder.greaterThanOrEqualTo(root.get(searchCriteria.getKey()), searchCriteria.getValue().toString());
        } else if (this.searchCriteria.getOperation().equals("<=")) {
            return criteriaBuilder.lessThanOrEqualTo(root.get(searchCriteria.getKey()), searchCriteria.getValue().toString());
        }

        return null;
    }
}
