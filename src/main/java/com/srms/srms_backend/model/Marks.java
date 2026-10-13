package com.srms.srms_backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "marks")
public class Marks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

    @Column(nullable = false)
    private int marksObtained;

    private String grade;
    private String result;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }

    public Subject getSubject() { return subject; }
    public void setSubject(Subject subject) { this.subject = subject; }

    public int getMarksObtained() { return marksObtained; }
    public void setMarksObtained(int marksObtained) {
        this.marksObtained = marksObtained;
        this.grade = calculateGrade(marksObtained);
        this.result = marksObtained >= 30 ? "Pass" : "Fail";
    }

    public String getGrade() { return grade; }
    public String getResult() { return result; }

    private String calculateGrade(int marks) {
        if (marks >= 90) return "A+";
        else if (marks >= 80) return "O";
        else if (marks >= 70) return "A";
        else if (marks >= 60) return "B";
        else if (marks >= 50) return "C";
        else if(marks >=40) return "D";
        else if(marks >=30) return "E";
        else return "F";
    }
}