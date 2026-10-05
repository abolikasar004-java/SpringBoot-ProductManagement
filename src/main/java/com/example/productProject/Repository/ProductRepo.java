package com.example.productProject.Repository;

import com.example.productProject.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepo extends JpaRepository<Product , Long> {


}
