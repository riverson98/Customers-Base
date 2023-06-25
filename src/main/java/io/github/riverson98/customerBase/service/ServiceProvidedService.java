package io.github.riverson98.customerBase.service;

import io.github.riverson98.customerBase.dto.ServiceProvidedDto;
import io.github.riverson98.customerBase.entity.ServiceProvided;
import io.github.riverson98.customerBase.repository.PersonRepository;
import io.github.riverson98.customerBase.repository.ServiceProvidedRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class ServiceProvidedService {
    private final PersonService personService;
    private final ServiceProvidedRepository serviceProvidedRepository;
    public ServiceProvidedService(PersonService personService, ServiceProvidedRepository serviceProvidedRepository) {
        this.personService = personService;
        this.serviceProvidedRepository = serviceProvidedRepository;
    }
    public ServiceProvided save(ServiceProvidedDto dto){
        LocalDate date = LocalDate.parse(dto.getDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        ServiceProvided serviceProvided = ServiceProvided.builder()
                .description(dto.getDescription())
                .price(convertToBigDecimal(dto.getPrice()))
                .date(date)
                .clientEntity(personService.findById(dto.getClientId()))
                .build();
        return serviceProvidedRepository.save(serviceProvided);

    }

    public BigDecimal convertToBigDecimal(String price){
        if (price != null){
            price = price.replace(".", "")
                    .replace(",", ".");
            return new BigDecimal(price);
        }
        return null;
    }

}
