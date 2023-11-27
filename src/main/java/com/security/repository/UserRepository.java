package com.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.security.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
   
   boolean existsById(Integer id);
   boolean existsByEmail(String email);
   boolean existsByUserName(String userName);
   
   User findByEmail(String email);
}
