package com.kcs.springboot.example.controller;

import com.kcs.springboot.example.data.Student;
import com.kcs.springboot.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }
    @GetMapping("/{studentId}")
    public Student getStudent(@PathVariable("studentId")String studentId){
        return studentService.getStudent(studentId);
    }

    @PostMapping("/save")
    public Student save(@RequestBody Student student){
        return studentService.createStudent(student);
    }

    @DeleteMapping("/{studentId}/delete")
    public void delete(@PathVariable("studentId") String studentId){
        studentService.deleteStudent(studentId);
    }

    @PutMapping("/{studentId}/update")
    public Student update(@PathVariable("studentId") String studentId, @RequestBody Student student){
        student.setId(Integer.parseInt(studentId));
        return studentService.updateStudent(student);
    }
}
