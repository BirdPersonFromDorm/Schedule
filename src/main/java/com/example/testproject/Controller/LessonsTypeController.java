package com.example.testproject.Controller;


import com.example.testproject.DTO.Request.LessonsDTORequest;
import com.example.testproject.DTO.Request.LessonsTypeDTORequest;
import com.example.testproject.DTO.Response.LessonsTypeDTOResponse;
import com.example.testproject.Service.LessonsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lessonsType")
public class LessonsTypeController {

    @Autowired
    LessonsTypeService lessonsTypeService;

    @GetMapping("/{id}")
    public LessonsTypeDTOResponse getInfo(@PathVariable int id){
        return lessonsTypeService.getInfo(id);
    }

    @PostMapping("/update/{id}")
    public void updateInfo(@PathVariable int id,
                           @RequestBody LessonsTypeDTORequest lessonsTypeDTORequest){
        lessonsTypeService.update(id, lessonsTypeDTORequest);
    }

    @GetMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        lessonsTypeService.delete(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody LessonsTypeDTORequest lessonsTypeDTORequest){
        lessonsTypeService.addNew(lessonsTypeDTORequest);
    }
}
