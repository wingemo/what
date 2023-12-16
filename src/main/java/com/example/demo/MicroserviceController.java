package com.example.demo;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class MicroserviceController {

  private final MicroserviceRepository repository;

  MicroserviceController(MicroserviceRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/microservices")
  List<Microservice> all() {
    return repository.findAll();
  }

  @PostMapping("/microservices")
  Microservice newMicroservice(@RequestBody Microservice newMicroservice) {
    return repository.save(newMicroservice);
  }

  @GetMapping("/microservices/{id}")
  Microservice one(@PathVariable Long id) {
    return repository.findById(id)
      .orElseThrow(() -> new MicroserviceNotFoundException(id));
  }

  @PutMapping("/microservices/{id}")
  Microservice replaceMicroservice(@RequestBody Microservice newMicroservice, @PathVariable Long id) {
    return repository.findById(id)
      .map(microservice -> {
        microservice.setServiceName(newMicroservice.getServiceName());
        microservice.setVersion(newMicroservice.getVersion());
        microservice.setDescription(newMicroservice.getDescription());
        microservice.setOwner(newMicroservice.getOwner());
        microservice.setStatus(newMicroservice.getStatus());
        microservice.setDependencies(newMicroservice.getDependencies());
        microservice.setCreatedAt(newMicroservice.getCreatedAt());
        microservice.setUpdatedAt(newMicroservice.getUpdatedAt());
        microservice.setLatestCommit(newMicroservice.getLatestCommit());
        microservice.setGitRepoLink(newMicroservice.getGitRepoLink());
        return repository.save(microservice);
      })
      .orElseGet(() -> {
        newMicroservice.setId(id);
        return repository.save(newMicroservice);
      });
  }

  @DeleteMapping("/microservices/{id}")
  void deleteMicroservice(@PathVariable Long id) {
    repository.deleteById(id);
  }
}