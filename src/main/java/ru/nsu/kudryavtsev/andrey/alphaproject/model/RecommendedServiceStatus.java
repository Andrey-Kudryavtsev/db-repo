package ru.nsu.kudryavtsev.andrey.alphaproject.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "recommended_service_statuses")
public class RecommendedServiceStatus {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private long id;

    @Column(name = "name", unique = true)
    @NotNull @Size(max = 13)
    @Getter @Setter
    private String name;

    @OneToMany(mappedBy = "status")
    @Getter @Setter
    private Set<RecommendedService> recommendedServices;
}
