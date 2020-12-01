package com.example.demo.controller;

import com.example.demo.dao.StudentService;
import com.example.demo.pojo.Student;
import com.fasterxml.jackson.databind.util.JSONPObject;
import jdk.nashorn.internal.ir.debug.JSONWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    public StudentService studentService;

    @RequestMapping("/")
    public String helloWorld() {
        return "Hello World";
    }

    @RequestMapping("/students")
    public List<Student> getStudent(@RequestParam(name = "name", required = false) String name, @RequestParam(name = "id", required = false) Integer id) {
        if(name == null && id == null)
            return studentService.findAll();
        else if(name != null)
            return studentService.findStudentByName(name);
        else
            return studentService.findStudentById(id);

    }

    @RequestMapping(value =  "/student/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Student> updateStudent(@RequestBody Student student, @PathVariable Integer id) {
        return ResponseEntity.ok(studentService.updateStudent(student, id));
    }

    @RequestMapping(value =  "/student/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> deleteStudent(@PathVariable Integer id) {
        return ResponseEntity.ok(studentService.deleteSTudent(id));
    }

    @RequestMapping(value =  "/student", method = RequestMethod.POST)
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        return ResponseEntity.ok(studentService.createStudent(student));
    }

}