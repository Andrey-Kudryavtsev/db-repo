package ru.nsu.kudryavtsev.andrey.alphaproject.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "client_awareness_statuses")
@NoArgsConstructor
public class ClientAwarenessStatus {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private long id;

    @Column(name = "name", unique = true)
    @NotNull
    @Size(max = 10)
    @Getter @Setter
    private String name;

    public ClientAwarenessStatus(String name) {
        this.name = name;
    }

//    @OneToMany(mappedBy = "clientAwarenessStatus")
//    @Getter @Setter
//    private Set<Order> orders;
}
