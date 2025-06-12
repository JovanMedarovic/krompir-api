package com.dragacevoshop.krompirApi.repositories;

import com.dragacevoshop.krompirApi.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
