package io.github.riverson98.customerBase.controller;

import io.github.riverson98.customerBase.entity.ClientEntity;
import io.github.riverson98.customerBase.service.PersonService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person")
@Slf4j
@Validated
@CrossOrigin("http://localhost:4200")
public class PersonController {
    PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity<ClientEntity> createClient(@Valid @RequestBody ClientEntity clientEntity) {
        log.info("start create person: {}", clientEntity.toString());
        return ResponseEntity.status(HttpStatus.CREATED).body(personService.createPerson(clientEntity));
    }

    @GetMapping
    public ResponseEntity<List<ClientEntity>>findAll(){
        return ResponseEntity.ok(personService.findAllPersons());
    }

    @GetMapping("{id}")
    public ResponseEntity<ClientEntity> findById(@PathVariable Integer id) {
        log.info("search person with id: {}", id);
        return ResponseEntity.ok(personService.findById(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        log.info("delete person with id: {}", id);
        personService.deletePerson(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updatePerson(@PathVariable Integer id, @Valid @RequestBody ClientEntity clientEntity) {
        log.info("update person with id: {} and requestBody: {}", id, clientEntity);
        personService.update(id, clientEntity);
        return ResponseEntity.noContent().build();
    }
}
