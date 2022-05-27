package com.preproject.spring.springboot.Repository;

import com.preproject.spring.springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
