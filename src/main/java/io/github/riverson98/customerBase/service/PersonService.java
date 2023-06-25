package io.github.riverson98.customerBase.service;

import io.github.riverson98.customerBase.entity.ClientEntity;
import io.github.riverson98.customerBase.repository.PersonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PersonService {
    final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public ClientEntity createPerson(ClientEntity clientEntity) {
        if (clientEntity != null) {
            return personRepository.save(clientEntity);
        }
        return null;
    }

    public List<ClientEntity> findAllPersons(){
        return personRepository.findAll();
    }

    public ClientEntity findById(Integer id) {
        return this.personRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public void deletePerson(Integer id) {
        this.personRepository.findById(id)
                .map(person -> {
                    personRepository.delete(person);
                    return Void.TYPE;
                }).orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND));

    }

    public void update(Integer id, ClientEntity clientEntity){
        this.personRepository
                .findById(id)
                .map(person -> {
                    person.setName(clientEntity.getName());
                    person.setCpf(clientEntity.getCpf());
                    return personRepository.save(clientEntity);
                })
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
