package io.github.riverson98.customerBase.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "person")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(nullable = false, length = 150)
    @NotBlank(message = "field name can be null or empty")
    private String name;
    @Column(nullable = false, length = 11)
    @NotBlank(message = "field cpf can be null or empty")
    private String cpf;
    @Column(name = "date_register", updatable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dateRegister;

    @PrePersist
    void prePersist() {
        setDateRegister(LocalDate.now());
    }

}
