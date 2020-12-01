package com.example.demo.dao;

import com.example.demo.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class StudentService {
    @Autowired
    public StudentRepository studentRepository;

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student createStudent(Student student) {
        return studentRepository.saveAndFlush(student);
    }

    public Student updateStudent(Student student, Integer id) {
        Optional<Student> x = studentRepository.findById(id);
        student.setId(id);
        if(x.isPresent()) {
            if(student.getName() == null) {
                student.setName(x.get().getName());
            }

            if(student.getClassification() == null) {
                student.setName(x.get().getClassification());
            }
            studentRepository.save(student);
            studentRepository.flush();
            return student;
        }

        return null;


    }

    public boolean deleteSTudent(Integer id) {
        studentRepository.deleteById(id);
        studentRepository.flush();
        return true;
    }

    public List<Student> findStudentById(Integer id) {
        List l = new ArrayList();
        l.add(id);
        return studentRepository.findAllById(l);
    }

    public List<Student> findStudentByName(String name) {
        Student student = new Student();
        student.setName(name);
        return studentRepository.findAll(Example.of(student));
    }
}
