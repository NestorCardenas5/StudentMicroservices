package com.nestor.gonzalo.cardenas.rojas.microservices.student.controller;

import com.nestor.gonzalo.cardenas.rojas.microservices.student.model.Student;
import com.nestor.gonzalo.cardenas.rojas.microservices.student.service.StudentServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class StudentController 	{
	@Autowired
    private StudentServiceImplement studentServiceImplement;

    @GetMapping("/student")
	public Flux<Student> findAll(){
        return studentServiceImplement.findAll();
	}
	@GetMapping("/student/{id}")
    public Mono<Student> getStudent(@PathVariable String id) {
        return studentServiceImplement.findById(id);
    }
	@GetMapping("student/numberDocument")
    public Mono<Student> findByNumberDocument(@RequestParam("number") String numberDocument) {
        return studentServiceImplement.findByNumberDocument(numberDocument);
    }

    @GetMapping("student/fullName")
    public Flux<Student> findFullName(@RequestParam("filter") String fullName) {
        return studentServiceImplement.findByFullName(fullName);
    }

    @PostMapping("/student")
    public void create(@RequestBody Student student) {
        studentServiceImplement.create(student);
    }

    @PutMapping("/student")
    public Mono<Student> save(@RequestBody Student student) {
        return studentServiceImplement.save(student);
    }

    @DeleteMapping("/student/{id}")
    public void delete(@PathVariable("id") String id) {
        studentServiceImplement.delete(id).subscribe();
    }
}
