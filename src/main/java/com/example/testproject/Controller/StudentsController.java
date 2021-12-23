package com.example.testproject.Controller;


import com.example.testproject.DTO.Request.PersonalInfoDTORequest;
import com.example.testproject.DTO.Request.StudentsDTORequest;
import com.example.testproject.DTO.Response.StudentsDTOResponse;
import com.example.testproject.Service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentsController {

    @Autowired
    StudentsService studentsService;

    @GetMapping("/{id}")
    public StudentsDTOResponse getInfo(@PathVariable int id){
        return studentsService.getInfo(id);
    }

    @GetMapping("/getByLastName")
    public List<StudentsDTOResponse> getLessonsByStudents(@RequestParam("lastName") String lastName){
        return studentsService.getLessonsByStudents(lastName);
    }

    @GetMapping("/getByLastNameAndDate")
    public List<StudentsDTOResponse> getLessonsByStudentsAndDate(@RequestParam("lastName") String lastName,
                                                                 @RequestParam("date") String date){
        return studentsService.getLessonsByStudentsAndDate(lastName, date);
    }

    @PutMapping("/update/{id}")
    public void updateInfo(@PathVariable int id,
                           @RequestBody StudentsDTORequest studentsDTORequest){
        studentsService.update(id, studentsDTORequest);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        studentsService.delete(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody StudentsDTORequest studentsDTORequest){
        studentsService.addNew(studentsDTORequest);
    }

}
