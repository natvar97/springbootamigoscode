package com.indialone.springbootamigoscode.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        if (studentRepository.findStudentByEmail(student.getEmail()).isPresent()) {
            throw new IllegalStateException("email token");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new IllegalStateException("student with id : " + id + " does not exists");
        }
        studentRepository.deleteById(id);
    }

    public void updateStudent(Long id, Student student) {
        if (!studentRepository.existsById(id)) {
            throw new IllegalStateException("student with id : " + student.getId() + " does not exists");
        }
        student.setId(id);
        studentRepository.save(student);
    }

}
