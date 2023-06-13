package io.github.riverson98.customerBase.service;

import io.github.riverson98.customerBase.entity.PersonEntity;
import io.github.riverson98.customerBase.repository.PersonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {
    final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public PersonEntity createPerson(PersonEntity personEntity) {
        if (personEntity != null) {
            return personRepository.save(personEntity);
        }
        return null;
    }

    public List<PersonEntity> findAllPersons(){
        return personRepository.findAll();
    }

    public PersonEntity findById(Long id) {
        return this.personRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public void deletePerson(Long id) {
        this.personRepository.findById(id)
                .map(person -> {
                    personRepository.delete(person);
                    return Void.TYPE;
                }).orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND));

    }

    public void update(Long id, PersonEntity personEntity){
        this.personRepository
                .findById(id)
                .map(person -> {
                    person.setName(personEntity.getName());
                    person.setCpf(personEntity.getCpf());
                    return personRepository.save(personEntity);
                })
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
