package io.github.riverson98.customerBase.controller;

import io.github.riverson98.customerBase.entity.PersonEntity;
import io.github.riverson98.customerBase.service.PersonService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person")
@Slf4j
@Validated
public class PersonController {
    PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity<PersonEntity> create(@Valid @RequestBody PersonEntity personEntity) {
        log.info("start create person: {}", personEntity.toString());
        return ResponseEntity.status(HttpStatus.CREATED).body(personService.createPerson(personEntity));
    }

    @GetMapping
    public ResponseEntity<List<PersonEntity>>findAll(){
        return ResponseEntity.ok(personService.findAllPersons());
    }

    @GetMapping("{id}")
    public ResponseEntity<PersonEntity> findById(@PathVariable long id) {
        log.info("search person with id: {}", id);
        return ResponseEntity.ok(personService.findById(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable long id) {
        log.info("delete person with id: {}", id);
        personService.deletePerson(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updatePerson(@PathVariable long id, @Valid @RequestBody PersonEntity personEntity) {
        log.info("update person with id: {} and requestBody: {}", id, personEntity);
        personService.update(id, personEntity);
        return ResponseEntity.noContent().build();
    }
}
