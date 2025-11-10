package com.skillhub.backend.util.filtros;

import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;
import java.util.Collection;

public final class JpaSpecificationUtils {

    private JpaSpecificationUtils() {}

    public static <T> Specification<T> like(String field, String value) {
        return (root, query, cb) -> (value == null || value.isBlank())
            ? cb.conjunction()
            : cb.like(cb.lower(root.get(field)), "%" + value.toLowerCase() + "%");
    }

    public static <T, V> Specification<T> eq(String field, V value) {
        return (root, query, cb) -> (value == null)
            ? cb.conjunction()
            : cb.equal(root.get(field), value);
    }

    public static <T> Specification<T> inList(String field, Collection<?> values) {
        return (root, query, cb) -> (values == null || values.isEmpty())
            ? cb.conjunction()
            : root.get(field).in(values);
    }

    public static <T> Specification<T> geDate(String field, LocalDateTime from) {
        return (root, query, cb) -> (from == null)
            ? cb.conjunction()
            : cb.greaterThanOrEqualTo(root.get(field), from);
    }

    public static <T> Specification<T> leDate(String field, LocalDateTime to) {
        return (root, query, cb) -> (to == null)
            ? cb.conjunction()
            : cb.lessThanOrEqualTo(root.get(field), to);
    }

    public static <T> Specification<T> betweenDate(String field, LocalDateTime from, LocalDateTime to) {
        return Specification.allOf(
            JpaSpecificationUtils.<T>geDate(field, from),
            JpaSpecificationUtils.<T>leDate(field, to)
        );
    }
}
