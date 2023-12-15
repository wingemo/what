package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MicroserviceRepository extends JpaRepository<Microservice, Long> {
}
