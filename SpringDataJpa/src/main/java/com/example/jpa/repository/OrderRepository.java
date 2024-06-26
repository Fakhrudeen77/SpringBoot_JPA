package com.example.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jpa.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}
