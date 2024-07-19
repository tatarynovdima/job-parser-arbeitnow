package org.example.jobparserarbeitnow.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record VacancyApiDto(
        String slug,
        @JsonProperty("company_name")
        String companyName,
        String title,
        boolean remote,
        String url,
        String location,
        @JsonProperty("created_at")
        Long createdAt
) {
}
