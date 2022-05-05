package ru.nsu.kudryavtsev.andrey.alphaproject.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "services")
public class Service {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private long id;

    @Column(name = "name", unique = true)
    @NotNull @Size(max = 256)
    @Getter @Setter
    private String name;

    @Column(name = "price")
    @NotNull
    @Getter @Setter
    private int price;

    @OneToMany(mappedBy = "service")
    @Getter @Setter
    private Set<RecommendedService> recommendedServices;
}
