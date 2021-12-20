package com.example.testproject.Repository;

import com.example.testproject.Model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursesRepository  extends JpaRepository<Courses, Integer> {
}
