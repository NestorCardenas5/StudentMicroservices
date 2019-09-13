package com.nestor.gonzalo.cardenas.rojas.microservices.student.repository;

import com.nestor.gonzalo.cardenas.rojas.microservices.student.model.Student;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StudentRepository extends ReactiveMongoRepository<Student, String> {
    Flux<Student> findByFullName(String fullName);

    Mono<Student> findByNumberDocument(String numberDocument);
}
