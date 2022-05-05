package ru.nsu.kudryavtsev.andrey.alphaproject.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "resource_amounts")
public class ResourceAmount {
    @EmbeddedId
    @Getter
    private ResourceAmountKey id;

    @ManyToOne
    @MapsId("recommendedServiceId")
    @JoinColumn(name = "recommended_service_id")
    @Getter @Setter
    private RecommendedService recommendedService;

    @ManyToOne
    @MapsId("resourceId")
    @JoinColumn(name = "resource_id")
    @Getter @Setter
    private Resource resource;

    @Column(name = "amount")
    @NotNull
    @Getter @Setter
    private int amount;
}
