package com.cognizant.springmockito.repository;

import com.cognizant.springmockito.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}