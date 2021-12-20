package com.example.testproject.Controller;

import com.example.testproject.DTO.Request.CoursesDTORequest;
import com.example.testproject.DTO.Response.CoursesDTOResponse;
import com.example.testproject.Model.Courses;
import com.example.testproject.Service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
public class CoursesController {

    @Autowired
    CoursesService coursesService;

    @GetMapping("/get/{id}")
    public CoursesDTOResponse getInfo(@PathVariable int id){
        return coursesService.getInfo(id);
    }

    @PostMapping("/update/{id}")
    public void updateInfo(@PathVariable int id, @RequestBody CoursesDTORequest coursesDTORequest){
         coursesService.update(id, coursesDTORequest);
    }

}
