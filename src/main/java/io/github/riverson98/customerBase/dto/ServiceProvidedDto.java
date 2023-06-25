package io.github.riverson98.customerBase.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ServiceProvidedDto {
    private String description;
    private String price;
    private String date;
    private Integer clientId;
}
