package com.srms.srms_backend.controller;

import com.srms.srms_backend.model.Student;
import com.srms.srms_backend.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentRepository.findById(id).orElse(null);
    }
@PutMapping("/{id}")
public Student updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) {
    Student existing = studentRepository.findById(id).orElse(null);
    if (existing == null) return null;
    
    existing.setName(updatedStudent.getName());
    existing.setRollNumber(updatedStudent.getRollNumber());
    existing.setDepartment(updatedStudent.getDepartment());
    existing.setYear(updatedStudent.getYear());
    
    return studentRepository.save(existing);
}

@DeleteMapping("/{id}")
public String deleteStudent(@PathVariable Long id) {
    studentRepository.deleteById(id);
    return "Student deleted successfully";
}
}