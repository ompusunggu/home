package com.louis.home.repository;

import com.louis.home.repository.entity.PersonalityGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonalityGroupRepository extends JpaRepository<PersonalityGroup, String> {

  List<PersonalityGroup> findAllByPersonalityId(String personalityId);

  @Query(value = "select psg.moduleId from PersonalityGroup psg where psg.personalityId=:personalityId")
  List<String> findAllModuleIdByPersonalityId(String personalityId);
}
