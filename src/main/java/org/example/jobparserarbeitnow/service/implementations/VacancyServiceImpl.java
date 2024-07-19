package org.example.jobparserarbeitnow.service.implementations;

import lombok.RequiredArgsConstructor;
import org.example.jobparserarbeitnow.dto.VisitedVacancyDto;
import org.example.jobparserarbeitnow.entity.Vacancy;
import org.example.jobparserarbeitnow.repository.VacancyRepository;
import org.example.jobparserarbeitnow.dto.responsemodel.Count;
import org.example.jobparserarbeitnow.service.interfaces.VacancyService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class VacancyServiceImpl implements VacancyService {
    private final VacancyRepository vacancyRepository;
    private static final Map<Long, Long> vacancyVisitMap =
            new HashMap<>();

    @Override
    public List<Vacancy> findAll(PageRequest pageRequest) {
        return vacancyRepository.findAll(pageRequest).toList();
    }

    @Override
    public Vacancy findById(Long id) {
        Vacancy vacancy = vacancyRepository.findById(id).orElseThrow(
                () -> new NoSuchElementException("No vacancy found with id " + id)
        );
        if (!vacancyVisitMap.containsKey(id)) {
            vacancyVisitMap.put(id, 0L);
        }
        vacancyVisitMap.put(id, vacancyVisitMap.get(id) + 1);
        return vacancy;
    }

    @Override
    public List<VisitedVacancyDto> getMostVisitedVacancies(int count) {
        List<Vacancy> vacancyList = vacancyRepository.findAll();

        List<VisitedVacancyDto> vacancyDtos = vacancyList.stream()
                .map(vacancy -> new VisitedVacancyDto(
                        vacancy.getId(),
                        vacancyVisitMap.getOrDefault(vacancy.getId(), 0L)  // Получаем количество посещений или 0, если нет данных
                ))
                .collect(Collectors.toList());

        vacancyDtos.sort(Comparator.comparingLong(VisitedVacancyDto::visits).reversed());

        return vacancyDtos.stream()
                .limit(count)
                .collect(Collectors.toList());
    }


    @Override
    public void saveAll(List<Vacancy> vacancies) {
        vacancyRepository.saveAll(vacancies);
    }

    @Override
    public List<Count> getCountByLocation() {
        return vacancyRepository.getCountByLocation();
    }

    @Override
    public Set<String> findAllSlugs() {
        return new HashSet<>(vacancyRepository.findAllSlugs());
    }
}
