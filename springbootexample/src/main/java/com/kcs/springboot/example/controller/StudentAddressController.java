package com.kcs.springboot.example.controller;

import com.kcs.springboot.example.data.Student;
import com.kcs.springboot.example.data.StudentAddress;
import com.kcs.springboot.example.service.StudentAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students/{studentId}/address")
public class StudentAddressController {
    private StudentAddressService studentAddressService;

    @Autowired
    public StudentAddressController(StudentAddressService studentAddressService) {
        this.studentAddressService = studentAddressService;
    }

    @GetMapping
    public List<StudentAddress> getStudentAddresses(@PathVariable("studentId") String studentId) {
        return studentAddressService.getStudentAddresses(studentId);
    }

    @GetMapping("/{addressId}")
    public StudentAddress getStudentAddress(@PathVariable("studentId") String studentId, @PathVariable("addressId") String addressId) {
        return studentAddressService.getStudentAddress(studentId, addressId);
    }

    @PostMapping
    public StudentAddress saveStudentAddress(@RequestBody StudentAddress studentAddress, @PathVariable("studentId") String studentId) {
        return studentAddressService.createStudentAddress(studentAddress, studentId);
    }

    @PutMapping("/{studentAddressId}/update")
    public StudentAddress updateStudentAddress(@PathVariable("studentAddressId") String studentAddressId, @PathVariable("studentId") String studentId, @RequestBody StudentAddress studentAddress) {
        studentAddress.setId(Integer.parseInt(studentAddressId));
        studentAddress.setStudentId(Integer.parseInt(studentId));
        return studentAddressService.updateStudentAddress(studentAddress);
    }

    @DeleteMapping("{studentAddressId}/delete")
    public void deleteStudentAddress(@PathVariable("studentId") String studentId, @PathVariable("studentAddressId") String studentAddressId) {
        studentAddressService.deleteStudentAddress(studentId, studentAddressId);
    }
}
