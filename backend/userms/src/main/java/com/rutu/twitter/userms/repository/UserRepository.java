package com.rutu.twitter.userms.repository;

import com.rutu.twitter.userms.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserName(String userName);

    Optional<User> findByEmail(String email);
}
