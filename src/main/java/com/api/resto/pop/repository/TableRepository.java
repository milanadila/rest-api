package com.api.resto.pop.repository;

import com.api.resto.pop.entity.TableOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TableRepository extends JpaRepository<TableOrder, Integer> {
}
