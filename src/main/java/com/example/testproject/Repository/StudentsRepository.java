package com.example.testproject.Repository;

import com.example.testproject.Model.Groups;
import com.example.testproject.Model.Students;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentsRepository extends JpaRepository<Students, Integer> {

    List<Students> findByLastName(String lastName);
}
