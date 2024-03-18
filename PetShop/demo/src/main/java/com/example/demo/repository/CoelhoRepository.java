package com.example.demo.repository;

import com.example.demo.model.Coelho;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoelhoRepository extends JpaRepository<Coelho, Long> {
}

