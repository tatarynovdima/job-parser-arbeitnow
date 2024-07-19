package org.example.jobparserarbeitnow.service.interfaces;

import org.example.jobparserarbeitnow.dto.VisitedVacancyDto;
import org.example.jobparserarbeitnow.entity.Vacancy;
import org.example.jobparserarbeitnow.dto.responsemodel.Count;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Set;

public interface VacancyService {
    List<Vacancy> findAll(PageRequest pageRequest);

    Vacancy findById(Long id);

    List<VisitedVacancyDto> getMostVisitedVacancies(int number);

    void saveAll(List<Vacancy> vacancies);

    List<Count> getCountByLocation();

    Set<String> findAllSlugs();
}
