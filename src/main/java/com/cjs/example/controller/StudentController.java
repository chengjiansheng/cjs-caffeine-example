package com.cjs.example.controller;

import com.cjs.example.model.Student;
import com.cjs.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @author ChengJianSheng
 * @date 2019-09-15
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/info/{studentId}")
    public Student info(@PathVariable("studentId") Integer studentId) {
        return studentService.getById(studentId);
    }

    @GetMapping("/getAll")
    public List<Student> getAll() {
        return studentService.getAll(Arrays.asList(101, 102, 103, 104, 105));
    }

    @GetMapping("/hitRate")
    public Double hitRate() {
        return studentService.hitRate();
    }
}

