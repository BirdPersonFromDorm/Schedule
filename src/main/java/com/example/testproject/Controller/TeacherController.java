package com.example.testproject.Controller;


import com.example.testproject.DTO.Request.StudentsDTORequest;
import com.example.testproject.DTO.Request.TeacherDTORequest;
import com.example.testproject.DTO.Response.TeacherDTOResponse;
import com.example.testproject.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    TeacherService teacherService;

    @GetMapping("/{id}")
    public TeacherDTOResponse getInfo(@PathVariable int id){

        return teacherService.getInfo(id);
    }

    @PostMapping("/update/{id}")
    public void updateInfo(@PathVariable int id,
                           @RequestBody TeacherDTORequest teacherDTORequest){
        teacherService.update(id, teacherDTORequest);
    }

    @GetMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        teacherService.delete(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody TeacherDTORequest teacherDTORequest){
        teacherService.addNew(teacherDTORequest);
    }
}
