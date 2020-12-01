package com.example.demo.dao;

import com.example.demo.pojo.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
//    @Query("FROM Student WHERE name = ?1")
//    List<Student> findByName(String name);
//
//    @Query("FROM Student WHERE id = ?1")
//    Student findById(String id);

}
