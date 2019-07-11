package com.louis.home.service.impl;

import com.louis.home.repository.PersonalityGroupRepository;
import com.louis.home.repository.PersonalityRepository;
import com.louis.home.repository.ModuleRepository;
import com.louis.home.repository.UserRepository;
import com.louis.home.repository.entity.Module;
import com.louis.home.repository.entity.PersonalityGroup;
import com.louis.home.repository.entity.User;
import com.louis.home.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PersonalityGroupRepository personalityGroupRepository;

  @Autowired
  private ModuleRepository moduleRepository;

  @Override
  public List<Module> getListOfModule(String userId) {
    User user = this.userRepository.findByEmail(userId);
    if(user != null){
      List<String> moduleIdList =
          this.personalityGroupRepository.findAllModuleIdByPersonalityId(user.getPersonalityId());

    return moduleIdList != null? this.moduleRepository.findAllByIdIn(moduleIdList) : Collections.emptyList();
    }

    return Collections.emptyList();
  }
}
