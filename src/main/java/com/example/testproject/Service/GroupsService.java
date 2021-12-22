package com.example.testproject.Service;

import com.example.testproject.DTO.Request.CoursesDTORequest;
import com.example.testproject.DTO.Request.GroupsDTORequest;
import com.example.testproject.DTO.Response.GroupsDTOResponse;
import com.example.testproject.Mapper.Request.GroupsMapperRequest;
import com.example.testproject.Mapper.Response.GroupsMapperResponse;
import com.example.testproject.Model.Courses;
import com.example.testproject.Model.Groups;
import com.example.testproject.Model.Lessons;
import com.example.testproject.Repository.GroupsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GroupsService {

    @Autowired
    GroupsRepository groupsRepository;

    @Autowired
    GroupsMapperResponse groupsMapper;

    @Autowired
    GroupsMapperRequest groupsMapperRequest;

    public GroupsDTOResponse getInfo(int id){
        Optional<Groups> byId = groupsRepository.findById(id);
        return groupsMapper.mapToDTO(byId.get());
    }

    public List<GroupsDTOResponse> getByName(String name){
        List<Groups> all = groupsRepository.findByName(name);
        List<GroupsDTOResponse> groupsDTOS = new ArrayList<>();
        for (int i = 0; i < all.size(); i++) {
            groupsDTOS.add(groupsMapper.mapToDTO(all.get(i)));
        }
        return groupsDTOS;
    }

    public void update(int id, GroupsDTORequest groupsDTORequest){
        Optional<Groups> byId = groupsRepository.findById(id);
        byId.get().setName(groupsDTORequest.getName());
        if(!groupsDTORequest.getLessons().isEmpty()){
            for (Lessons lessons:groupsDTORequest.getLessons()) {
                byId.get().getLessons().add(lessons);
            }
        }
        groupsRepository.save(byId.get());
    }

    public void delete(int id){
        groupsRepository.deleteById(id);
    }

    public void addNew(GroupsDTORequest groupsDTORequest){
        Groups groups = groupsMapperRequest.mapToDTO(groupsDTORequest);
        groupsRepository.save(groups);
    }


}
