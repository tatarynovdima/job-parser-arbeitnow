package org.example.jobparserarbeitnow.dto;

public record VacancyDto(
        String companyName,
        String title,
        boolean remote,
        String url,
        String location,
        Long createdAt
) {
}
