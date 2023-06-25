package io.github.riverson98.customerBase.controller;

import io.github.riverson98.customerBase.dto.ServiceProvidedDto;
import io.github.riverson98.customerBase.entity.ServiceProvided;
import io.github.riverson98.customerBase.service.ServiceProvidedService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/service")
public class ServiceProvidedController {
    private final ServiceProvidedService service;

    public ServiceProvidedController(ServiceProvidedService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ServiceProvided> save(@RequestBody ServiceProvidedDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(dto));
    }
}
