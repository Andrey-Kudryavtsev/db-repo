package ru.nsu.kudryavtsev.andrey.alphaproject.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "completion_statuses")
@NoArgsConstructor
public class CompletionStatus {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private long id;

    @Column(name = "name", unique = true)
    @NotNull
    @Size(max = 8)
    @Getter @Setter
    private String name;

    public CompletionStatus(String name) {
        this.name = name;
    }

//    @OneToMany(mappedBy = "completionStatus")
//    @Getter @Setter
//    private Set<Order> orders;
}
