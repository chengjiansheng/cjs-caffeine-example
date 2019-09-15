package com.cjs.example.controller;

import com.cjs.example.model.Teacher;
import com.cjs.example.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ChengJianSheng
 * @date 2019-09-15
 */
@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/info/{id}")
    public Teacher info(@PathVariable("id") Integer teacherId) {
        return teacherService.getById(teacherId);
    }

}
