package com.example.demo;

class MicroserviceNotFoundException extends RuntimeException {
  MicroserviceNotFoundException(Long id) {
    super("Could not find employee " + id);
  }
}