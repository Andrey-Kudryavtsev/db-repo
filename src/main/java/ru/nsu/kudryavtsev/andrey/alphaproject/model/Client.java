package ru.nsu.kudryavtsev.andrey.alphaproject.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "clients")
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
public class Client {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private long id;

    @Column(name = "phone_number", unique = true)
    @NotNull
    @Size(max = 16)
    @Getter @Setter
    private String phoneNumber;

//    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL)
//    @PrimaryKeyJoinColumn
//    @Getter @Setter
//    private PhysicalPerson physicalPerson;

//    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL)
//    @PrimaryKeyJoinColumn
//    @Getter @Setter
//    private JuridicalPerson juridicalPerson;

//    @OneToMany(mappedBy = "client")
//    @Getter @Setter
//    private Set<Order> orders;

    public Client(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
