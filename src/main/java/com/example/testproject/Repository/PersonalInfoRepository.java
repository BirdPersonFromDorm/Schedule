package com.example.testproject.Repository;

import com.example.testproject.Model.PersonalInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalInfoRepository extends JpaRepository<PersonalInfo, Integer> {

}
