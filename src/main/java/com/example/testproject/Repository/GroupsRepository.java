package com.example.testproject.Repository;

import com.example.testproject.Model.Groups;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupsRepository extends JpaRepository<Groups, Integer> {

     List<Groups> findByName(String name);

}
