package com.srms.srms_backend.controller;

import com.srms.srms_backend.model.Marks;
import com.srms.srms_backend.repository.MarksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/marks")
@CrossOrigin(origins = "*")
public class MarksController {

    @Autowired
    private MarksRepository marksRepository;

    @GetMapping
    public List<Marks> getAllMarks() {
        return marksRepository.findAll();
    }

    @PostMapping
    public Marks addMarks(@RequestBody Marks marks) {
        return marksRepository.save(marks);
    }

    @GetMapping("/student/{studentId}")
    public List<Marks> getMarksByStudent(@PathVariable Long studentId) {
        return marksRepository.findByStudentId(studentId);
    }
}