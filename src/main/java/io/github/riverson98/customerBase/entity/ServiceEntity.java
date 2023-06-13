package io.github.riverson98.customerBase.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "service")
@Data
@AllArgsConstructor
@Builder
public class ServiceEntity {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private final long id;
    @Column
    private final String description;
    @ManyToOne
    @JoinColumn(name = "person_id")
    private PersonEntity personEntity;
    @Column(nullable = false)
    private final BigDecimal price;

}
