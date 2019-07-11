package com.louis.home.repository;

import com.louis.home.repository.entity.Module;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModuleRepository extends JpaRepository<Module, String> {

  List<Module> findAllByIdIn(List<String> moduleId);
}
