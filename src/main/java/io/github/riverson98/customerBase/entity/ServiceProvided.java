package io.github.riverson98.customerBase.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "service")
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ServiceProvided {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column
    private String description;
    @ManyToOne
    @JoinColumn(name = "person_id")
    private ClientEntity clientEntity;
    @Column(nullable = false)
    private BigDecimal price;
    @Column
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate date;

}
