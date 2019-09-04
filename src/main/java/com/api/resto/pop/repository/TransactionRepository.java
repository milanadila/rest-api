package com.api.resto.pop.repository;

import com.api.resto.pop.entity.TransactionInvoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionInvoice, Integer> {
}
