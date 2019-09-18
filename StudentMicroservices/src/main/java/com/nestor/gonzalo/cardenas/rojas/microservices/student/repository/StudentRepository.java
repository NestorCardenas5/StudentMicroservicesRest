package com.nestor.gonzalo.cardenas.rojas.microservices.student.repository;

import com.nestor.gonzalo.cardenas.rojas.microservices.student.models.documents.Student;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StudentRepository {
    //Student Maintenance

    Flux<Student> findAll();

    Mono<Student> findById(String id);

    Mono<Student> save(Student student);

    Mono<Void> delete(Student student);

    //Business Methods

    Mono<Student> findByFullName(String fullName);

    Mono<Student> findByNumberDocument(String numberDocument);
}
