package org.example.jobparserarbeitnow.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.example.jobparserarbeitnow.dto.VacancyDto;
import org.example.jobparserarbeitnow.dto.VisitedVacancyDto;
import org.example.jobparserarbeitnow.dto.mapper.impl.VacancyMapper;
import org.example.jobparserarbeitnow.dto.responsemodel.Count;
import org.example.jobparserarbeitnow.service.interfaces.VacancyService;
import org.example.jobparserarbeitnow.utils.SortUtil;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vacancies")
@RequiredArgsConstructor
public class VacancyController {
    private final VacancyService vacancyService;
    private final VacancyMapper vacancyMapper;
    private final SortUtil sortUtil;

    @Operation(description = "Retrieve a sorted and paginated list of all vacancies.")
    @GetMapping
    public List<VacancyDto> findAll(@RequestParam(defaultValue = "20")
                                    @Parameter(description =
                                            "The number of vacancies per page. Default value is 20.")
                                    Integer count,
                                    @RequestParam(defaultValue = "0")
                                    @Parameter(description =
                                            "The page number to retrieve. Default value is 0.")
                                    Integer page,
                                    @RequestParam(defaultValue = "createdAt")
                                    @Parameter(description =
                                            "The field to sort by. Default value is createdAt.")
                                    String sortBy) {
        Sort sort = sortUtil.getSort(sortBy);
        PageRequest pageRequest = PageRequest.of(page, count, sort);
        return vacancyService.findAll(pageRequest)
                .stream()
                .map(vacancyMapper::toDto)
                .toList();
    }

    @Operation(description = "Retrieve detailed information about a vacancy by its ID.")
    @GetMapping("/{id}")
    public VacancyDto findBySlug(@PathVariable
                                 @Parameter(description =
                                         "The vacancy ID to show info about.")
                                 Long id) {
        return vacancyMapper.toDto(vacancyService.findById(id));
    }

    @Operation(description = "Retrieve a list of the most visited vacancies' IDs.")
    @GetMapping("/most-visited")
    public List<VisitedVacancyDto> getMostVisitedVacancies(
            @RequestParam(name = "count", defaultValue = "10")
            @Parameter(description =
                    "The number of top visited vacancies IDs to show.")
            int number) {
        return vacancyService.getMostVisitedVacancies(number);
    }

    @Operation(description = "Retrieve a count of all vacancies grouped by location.")
    @GetMapping("/group-by-location")
    public List<Count> getCountsByLocation() {
        return vacancyService.getCountByLocation();
    }
}
