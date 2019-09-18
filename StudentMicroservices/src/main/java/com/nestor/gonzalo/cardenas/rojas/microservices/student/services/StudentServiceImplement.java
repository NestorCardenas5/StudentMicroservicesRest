package com.nestor.gonzalo.cardenas.rojas.microservices.student.services;

import com.nestor.gonzalo.cardenas.rojas.microservices.student.models.dao.StudentDao;
import com.nestor.gonzalo.cardenas.rojas.microservices.student.models.documents.Student;
import com.nestor.gonzalo.cardenas.rojas.microservices.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StudentServiceImplement implements StudentRepository {
    @Autowired
    private StudentDao dao;

    //Student Maintenance
    @Override
    public Flux<Student> findAll() {
        return dao.findAll();
    }

    @Override
    public Mono<Student> findById(String id) {
        return dao.findById(id);
    }

    @Override
    public Mono<Student> save(Student student) {
        return dao.save(student);
    }

    @Override
    public Mono<Void> delete(Student student) {
        return dao.delete(student);
    }

    //Business Methods

    @Override
    public Mono<Student> findByFullName(String fullName) {
        return dao.findByFullName(fullName);
    }

    @Override
    public Mono<Student> findByNumberDocument(String numberDocument) {
        return dao.findByNumberDocument(numberDocument);
    }
}
