package ru.nsu.kudryavtsev.andrey.alphaproject.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "Acceptors")
@NoArgsConstructor
public class Acceptor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private long id;

    @Column(name = "full_name")
    @NotNull @Size(max = 256)
    @Getter @Setter
    private String fullName;

//    @OneToMany(mappedBy = "acceptor")
//    @Getter @Setter
//    private Set<Order> orders;

    public Acceptor(String fullName) {
        this.fullName = fullName;
    }
}
