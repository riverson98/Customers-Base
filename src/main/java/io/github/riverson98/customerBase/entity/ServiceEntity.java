package io.github.riverson98.customerBase.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "service")
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ServiceEntity {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column
    private String description;
    @ManyToOne
    @JoinColumn(name = "person_id")
    private ClientEntity clientEntity;
    @Column(nullable = false)
    private BigDecimal price;

}
