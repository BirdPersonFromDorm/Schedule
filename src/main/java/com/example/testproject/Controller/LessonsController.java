package com.example.testproject.Controller;


import com.example.testproject.DTO.Request.GroupsDTORequest;
import com.example.testproject.DTO.Request.LessonsDTORequest;
import com.example.testproject.DTO.Response.LessonsDTOResponse;
import com.example.testproject.Service.LessonsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lessons")
public class LessonsController {

    @Autowired
    LessonsService lessonsService;

    @GetMapping("/{id}")
    public LessonsDTOResponse getInfo(@PathVariable int id){
        return lessonsService.getInfo(id);
    }

    @PutMapping("/update/{id}")
    public void updateInfo(@PathVariable int id,
                           @RequestBody LessonsDTORequest lessonsDTORequest){
        lessonsService.update(id, lessonsDTORequest);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        lessonsService.delete(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody LessonsDTORequest lessonsDTORequest){
        lessonsService.addNew(lessonsDTORequest);
    }
}
