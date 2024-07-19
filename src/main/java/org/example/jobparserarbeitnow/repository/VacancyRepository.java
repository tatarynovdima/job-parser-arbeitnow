package org.example.jobparserarbeitnow.repository;

import org.example.jobparserarbeitnow.entity.Vacancy;
import org.example.jobparserarbeitnow.dto.responsemodel.Count;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VacancyRepository extends JpaRepository<Vacancy, Long> {
    @Query("SELECT new org.example.jobparserarbeitnow.dto.responsemodel.Count(v.location, COUNT(v)) " +
            "FROM Vacancy v " +
            "GROUP BY v.location " +
            "ORDER BY COUNT(v) DESC")
    List<Count> getCountByLocation();


    @Query("SELECT v.slug FROM Vacancy v")
    List<String> findAllSlugs();
}