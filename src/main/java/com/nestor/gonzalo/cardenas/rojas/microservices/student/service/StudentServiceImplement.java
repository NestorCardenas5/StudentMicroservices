package com.nestor.gonzalo.cardenas.rojas.microservices.student.service;


import com.nestor.gonzalo.cardenas.rojas.microservices.student.model.Student;
import com.nestor.gonzalo.cardenas.rojas.microservices.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StudentServiceImplement implements StudentInterface {
	
	@Autowired
	public StudentRepository studentRepository;
	
	@Override
    public void create(Student s) {
        studentRepository.save(s).subscribe();
    }
	@Override
	public Flux<Student> findAll() {
		return studentRepository.findAll();
	}
	@Override
	public Mono<Student> findById(String id) {
        return studentRepository.findById(id);
	}
	@Override
	public Mono<Student> save(Student student) {
		return studentRepository.save(student);
	}

    @Override
    public Mono<Void> delete(String id) {
        return studentRepository.deleteById(id);
    }
	@Override
    public Flux<Student> findByFullName(String fullName) {
        return studentRepository.findByFullName(fullName);
    }

    @Override
    public Mono<Student> findByNumberDocument(String numberDocument) {
        return studentRepository.findByNumberDocument(numberDocument);
    }

    @Override
    public Flux<Student> findByDate(String birthdate) {
        return null;
    }
}
