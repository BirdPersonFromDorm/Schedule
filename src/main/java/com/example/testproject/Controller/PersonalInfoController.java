package com.example.testproject.Controller;

import com.example.testproject.DTO.Request.LessonsTypeDTORequest;
import com.example.testproject.DTO.Request.PersonalInfoDTORequest;
import com.example.testproject.Service.PersonalInfoService;
import com.example.testproject.Model.PersonalInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/personalInfo")
public class PersonalInfoController {

    @Autowired
    PersonalInfoService personalInfoService;

    @GetMapping("/{id}")
    public PersonalInfo getInfo(@PathVariable int id){

        return personalInfoService.getInfo(id);
    }

    @PostMapping("/update/{id}")
    public void updateInfo(@PathVariable int id,
                           @RequestBody PersonalInfoDTORequest personalInfoDTORequest){
        personalInfoService.update(id, personalInfoDTORequest);
    }

    @GetMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        personalInfoService.delete(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody PersonalInfoDTORequest personalInfoDTORequest){
        personalInfoService.addNew(personalInfoDTORequest);
    }
}
