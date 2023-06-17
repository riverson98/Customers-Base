package io.github.riverson98.customerBase.repository;

import io.github.riverson98.customerBase.entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<ClientEntity, Long> {
}
