package com.java.todomangement.Todo_Mangement.repository;

import com.java.todomangement.Todo_Mangement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserName(String name);

    boolean existsByEmail(String email);
    Optional<User> findByUserNameOrEmail(String name, String email);
    boolean existsByUserName(String name);
}
