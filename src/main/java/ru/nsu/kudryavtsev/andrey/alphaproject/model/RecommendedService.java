package ru.nsu.kudryavtsev.andrey.alphaproject.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "recommended_services")
public class RecommendedService {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private long id;

    @ManyToOne
    @JoinColumn(name = "status_id")
    @Getter @Setter
    private RecommendedServiceStatus status;

//    @ManyToOne
//    @JoinColumn(name = "order_id")
//    @NotNull
//    @Getter @Setter
//    private Order order;

    @ManyToOne
    @JoinColumn(name = "service_id")
    @NotNull
    @Getter @Setter
    private Service service;

    @OneToMany(mappedBy = "recommendedService")
    @Getter @Setter
    private Set<ResourceAmount> resourceAmounts;
}
