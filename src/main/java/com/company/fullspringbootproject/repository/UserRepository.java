package com.company.fullspringbootproject.repository;

import com.company.fullspringbootproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUserIdAndDeletedAtIsNull(Integer userId);
}
