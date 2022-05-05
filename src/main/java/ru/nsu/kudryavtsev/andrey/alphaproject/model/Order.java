package ru.nsu.kudryavtsev.andrey.alphaproject.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "orders")
@NoArgsConstructor
public class Order {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "completion_status_id")
    @NotNull
    @Getter @Setter
    private CompletionStatus completionStatus;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "client_awareness_status_id")
    @NotNull
    @Getter @Setter
    private ClientAwarenessStatus clientAwarenessStatus;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "payment_status_id")
    @NotNull
    @Getter @Setter
    private PaymentStatus paymentStatus;

    @Column(name = "date_of_receiving")
    @NotNull
    @Getter @Setter
    private LocalDate dateOfReceiving;

    @Column(name = "date_of_completion")
    @Getter @Setter
    private LocalDate dateOfCompletion;

    @Column(name = "date_of_return")
    @Getter @Setter
    private LocalDate dateOfReturn;

    @Column(name = "deadline")
    @Getter @Setter
    private LocalDate deadline;

    @Column(name = "complaints_and_requirements", columnDefinition="TEXT")
    @NotNull
    @Getter @Setter
    private String complaintsAndRequirements;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "acceptor_id")
    @NotNull
    @Getter @Setter
    private Acceptor acceptor;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "master_id")
    @Getter @Setter
    private Master master;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "client_id")
    @NotNull
    @Getter @Setter
    private Client client;

    public Order(CompletionStatus completionStatus,
                 ClientAwarenessStatus clientAwarenessStatus,
                 PaymentStatus paymentStatus,
                 LocalDate dateOfReceiving,
                 LocalDate deadline,
                 String complaintsAndRequirements,
                 Acceptor acceptor,
                 Master master,
                 Client client){
        this.completionStatus = completionStatus;
        this.clientAwarenessStatus = clientAwarenessStatus;
        this.paymentStatus = paymentStatus;
        this.dateOfReceiving = dateOfReceiving;
        this.deadline = deadline;
        this.complaintsAndRequirements = complaintsAndRequirements;
        this.acceptor = acceptor;
        this.master = master;
        this.client = client;
    }

//    @OneToMany(mappedBy = "order")
//    @Getter @Setter
//    private Set<Device> devices;

//    @OneToMany(mappedBy = "order")
//    @Getter @Setter
//    private Set<RecommendedService> recommendedServices;
}
