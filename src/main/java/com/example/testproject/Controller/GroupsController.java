package com.example.testproject.Controller;


import com.example.testproject.DTO.Request.CoursesDTORequest;
import com.example.testproject.DTO.Request.GroupsDTORequest;
import com.example.testproject.DTO.Response.GroupsDTOResponse;
import com.example.testproject.Service.GroupsService;
import com.example.testproject.Model.Groups;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupsController {

    @Autowired
    GroupsService groupsService;

    @GetMapping("/{id}")
    public GroupsDTOResponse getInfo(@PathVariable int id){
        return groupsService.getInfo(id);
    }

    @GetMapping("/getByName")
    public List<GroupsDTOResponse> getInfo(@RequestParam("name") String name){
        return groupsService.getByName(name);
    }

    @PostMapping("/update/{id}")
    public void updateInfo(@PathVariable int id, @RequestBody GroupsDTORequest groupsDTORequest){
        groupsService.update(id, groupsDTORequest);
    }

}
