package ru.nsu.kudryavtsev.andrey.alphaproject.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "juridical_persons")
@PrimaryKeyJoinColumn(name = "client_id")
@OnDelete(action = OnDeleteAction.CASCADE)
@NoArgsConstructor
public class JuridicalPerson extends Client {
    @Column(name = "name", unique = true)
    @NotNull
    @Size(max = 256)
    @Getter @Setter
    private String name;

    public JuridicalPerson(String name, String phoneNumber) {
        super(phoneNumber);
        this.name = name;
    }
}
