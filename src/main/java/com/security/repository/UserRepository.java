package com.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
   
   boolean existsById(Integer userId);
   boolean existsByEmail(String email);
   boolean existsByNickname(String nickname);
   
   User findByEmail(String email);
}
