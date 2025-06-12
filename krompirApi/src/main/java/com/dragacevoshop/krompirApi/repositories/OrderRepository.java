package com.dragacevoshop.krompirApi.repositories;

import com.dragacevoshop.krompirApi.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
