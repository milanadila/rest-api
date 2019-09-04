package com.api.resto.pop.repository;

import com.api.resto.pop.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {

    @Override
    Optional<Menu> findById(Integer integer);
}
