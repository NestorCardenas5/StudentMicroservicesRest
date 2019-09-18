package com.nestor.gonzalo.cardenas.rojas.microservices.student.controllers;

import com.nestor.gonzalo.cardenas.rojas.microservices.student.models.dao.StudentDao;
import com.nestor.gonzalo.cardenas.rojas.microservices.student.models.documents.Student;
import com.nestor.gonzalo.cardenas.rojas.microservices.student.repository.StudentRepository;
import com.nestor.gonzalo.cardenas.rojas.microservices.student.services.StudentServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentServiceImplement studentServiceImplement;

    //Student Maintenance
    @PostMapping
    public Mono<ResponseEntity<Student>> CreateStudent(@RequestBody Student student) {
        return studentServiceImplement.save(student).map(s -> ResponseEntity
                .created(URI.create("/api/student/".concat(s.getId())))
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(s)
        );
    }

    @GetMapping
    public Mono<ResponseEntity<Flux<Student>>> StudentList() {
        return Mono.just(
                ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                        .body(studentServiceImplement.findAll())
        );
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<Student>> SearchStudent(@PathVariable String id) {
        return studentServiceImplement.findById(id).map(s -> ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(s))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<Student>> EditStudent(@RequestBody Student student, @PathVariable String id) {
        return studentServiceImplement.findById(id).flatMap(s -> {
            s.setFullName(student.getFullName());
            s.setGender(student.getGender());
            s.setBirthdate(student.getBirthdate());
            s.setTypeDocument(student.getTypeDocument());
            s.setNumberDocument(student.getNumberDocument());
            return studentServiceImplement.save(s);
        }).map(s -> ResponseEntity.created(URI.create("/api/student/".concat(s.getId())))
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(s))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> RemoveStudent(@PathVariable String id) {
        return studentServiceImplement.findById(id).flatMap(s -> {
            return studentServiceImplement.delete(s).then(Mono.just(new ResponseEntity<Void>(HttpStatus.NO_CONTENT)));
        }).defaultIfEmpty(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));
    }
    //Business Methods    findByFullName
    @GetMapping("fullName/{fullName}")
    public Mono<ResponseEntity<Student>> findByFullName(@PathVariable ("fullName") String fullName){
        return studentServiceImplement.findByFullName(fullName).map(s-> ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(s))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("numberDocument/{number}")
    public Mono<ResponseEntity<Student>> findByNumberDocument(@PathVariable String number){
        return studentServiceImplement.findByNumberDocument(number).map(s-> ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(s))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
