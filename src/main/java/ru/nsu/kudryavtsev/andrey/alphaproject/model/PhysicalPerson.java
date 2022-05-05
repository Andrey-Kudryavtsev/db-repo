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
@Table(name = "physical_persons")
@PrimaryKeyJoinColumn(name = "client_id")
@OnDelete(action = OnDeleteAction.CASCADE)
@NoArgsConstructor
public class PhysicalPerson extends Client{
    @Column(name = "full_name")
    @NotNull
    @Size(max = 256)
    @Getter @Setter
    private String fullName;

    public PhysicalPerson(String fullName, String phoneNumber) {
        super(phoneNumber);
        this.fullName = fullName;
    }
}
