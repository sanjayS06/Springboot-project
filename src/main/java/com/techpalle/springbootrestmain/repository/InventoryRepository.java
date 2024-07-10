package com.techpalle.springbootrestmain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techpalle.springbootrestmain.entity.Product;
@Repository
public interface InventoryRepository extends JpaRepository<Product, Integer> {

}
