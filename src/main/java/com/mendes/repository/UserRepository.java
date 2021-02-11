package com.mendes.repository;

import com.mendes.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by mendesmustafa on 11.02.2021.
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
