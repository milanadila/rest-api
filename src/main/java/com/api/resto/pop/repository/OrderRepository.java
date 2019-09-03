package com.api.resto.pop.repository;

import com.api.resto.pop.entity.OrderFood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderFood, Integer> {

    List<OrderFood> findByIdTable(Integer id);

    OrderFood findByIdOrder(Integer id);

    void deleteById(Integer id);
}
