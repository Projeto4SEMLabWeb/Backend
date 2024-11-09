package com.example.demo.Repository;

import com.example.demo.Model.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstoqueRepository extends JpaRepository< Estoque,Long> {
}
