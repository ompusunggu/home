package com.louis.home.repository;

import com.louis.home.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String>{

  User findByEmail(String email);
}
