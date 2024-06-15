package com.example.financialproductpreference.repository;

import com.example.financialproductpreference.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
