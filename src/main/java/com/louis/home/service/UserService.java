package com.louis.home.service;

import com.louis.home.repository.entity.Module;

import java.util.List;

public interface UserService {
  List<Module> getListOfModule(String userId);
}
