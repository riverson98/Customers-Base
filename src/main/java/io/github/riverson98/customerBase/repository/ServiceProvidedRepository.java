package io.github.riverson98.customerBase.repository;

import io.github.riverson98.customerBase.entity.ServiceProvided;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceProvidedRepository extends JpaRepository<ServiceProvided, Integer> {
}
