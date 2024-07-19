package org.example.jobparserarbeitnow.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;


@Entity
@Table(name = "vacancies")
@Getter
@Setter
@NoArgsConstructor
public class Vacancy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String slug;
    @JsonProperty("company_name")
    private String companyName;
    private String title;
    private boolean remote;
    private String url;
    private String location;
    @JsonProperty("created_at")
    private Long createdAt;
}
