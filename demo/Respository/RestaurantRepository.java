package com.example.demo.Respository;

import com.example.demo.Entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
}
