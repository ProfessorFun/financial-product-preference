package com.example.financialproductpreference.repository;

import com.example.financialproductpreference.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
