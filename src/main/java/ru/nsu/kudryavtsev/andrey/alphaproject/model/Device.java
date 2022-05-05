package ru.nsu.kudryavtsev.andrey.alphaproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "devices")
@NoArgsConstructor
public class Device {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private long id;

    @Column(name = "serial_number")
    @NotNull @Size(max = 256)
    @Getter @Setter
    private String serialNumber;

    @ManyToOne(fetch = FetchType.EAGER, optional = false) // TODO: do with LAZY
    @JoinColumn(name = "model_id")
    @NotNull
//    @JsonManagedReference
//    @JsonIgnore
    @Getter @Setter
    private Model model;

    public Device(String serialNumber, Model model) {
        this.serialNumber = serialNumber;
        this.model = model;
    }

//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "order_id")
//    @NotNull
//    @OnDelete(action = OnDeleteAction.CASCADE)
//    @JsonIgnore
//    @Getter @Setter
//    private Order order;
}
