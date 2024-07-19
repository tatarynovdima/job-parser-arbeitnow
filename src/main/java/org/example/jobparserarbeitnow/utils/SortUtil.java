package org.example.jobparserarbeitnow.utils;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SortUtil {
    private static final int ORDER_DIRECTION_INDEX = 1;
    private static final int FIELD_INDEX = 0;
    private static final String SPLIT_DELIMITER = ":";

    public Sort getSort(String sortBy) {
        Sort.Order createdAtOrder = Sort.Order.desc("createdAt");
        Sort.Order titleOrder = Sort.Order.asc("title");

        if (sortBy.contains(":")) {
            String[] fieldAndOrder = sortBy.split(SPLIT_DELIMITER);
            createdAtOrder = new Sort.Order(
                    Sort.Direction.fromString(fieldAndOrder[ORDER_DIRECTION_INDEX]),
                    fieldAndOrder[FIELD_INDEX]);
        }

        return Sort.by(List.of(createdAtOrder, titleOrder));
    }
}
