package com.pat.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.pat.model.User;

public interface UserRepository extends JpaRepository<User, Long>{


}
