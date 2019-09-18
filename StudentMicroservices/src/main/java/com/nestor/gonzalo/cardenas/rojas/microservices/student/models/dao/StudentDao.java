package com.nestor.gonzalo.cardenas.rojas.microservices.student.models.dao;

import com.nestor.gonzalo.cardenas.rojas.microservices.student.models.documents.Student;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StudentDao extends ReactiveMongoRepository<Student, String> {

    Mono<Student> findByFullName(String fullName);

    Mono<Student> findByNumberDocument(String numberDocument);
}
