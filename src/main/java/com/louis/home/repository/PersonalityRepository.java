package com.louis.home.repository;

import com.louis.home.repository.entity.Personality;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalityRepository extends JpaRepository<Personality, String> {

}
