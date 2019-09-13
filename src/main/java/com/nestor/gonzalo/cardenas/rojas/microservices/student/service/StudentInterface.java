package com.nestor.gonzalo.cardenas.rojas.microservices.student.service;


import com.nestor.gonzalo.cardenas.rojas.microservices.student.model.Student;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StudentInterface {

    void create(Student s);
    Flux<Student> findAll();
    Mono<Student> findById(String id);
    Mono<Student> save(Student student);
    Mono<Void> delete(String id);

    Flux<Student> findByFullName(String fullName);

    Mono<Student> findByNumberDocument(String numberDocument);

    Flux<Student> findByDate(String birthdate);

}
